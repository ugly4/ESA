package com.example.esajms.controllers;

import com.example.esajms.services.SongService;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;
    private final ResourceLoader resourceLoader;

    @Autowired
    public SongController(SongService songService, ResourceLoader resourceLoader) {
        this.songService = songService;
        this.resourceLoader = resourceLoader;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String getAlbums() throws IOException, TransformerException {
        String xmlData = songService.getAsXml();

        Resource xslResource = resourceLoader.getResource("classpath:templates/songs.xsl");
        StreamSource xslStreamSource = new StreamSource(xslResource.getInputStream());

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(xslStreamSource);

        StreamSource xmlStreamSource = new StreamSource(new java.io.StringReader(xmlData));
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);

        transformer.transform(xmlStreamSource, result);

        return writer.toString();
    }

}
