package com.example.esajms.controllers;

import com.example.esajms.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringWriter;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;
    private final ResourceLoader resourceLoader;

    @Autowired
    public AlbumController(AlbumService albumService, ResourceLoader resourceLoader) {
        this.albumService = albumService;
        this.resourceLoader = resourceLoader;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String getAlbums() throws IOException, TransformerException {
        String xmlData = albumService.getAsXml();

        Resource xslResource = resourceLoader.getResource("classpath:templates/albums.xsl");
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
