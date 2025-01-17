package com.example.esajms.controllers;

import com.example.esajms.beans.ArtistServiceBean;
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
@RequestMapping("/")
public class ArtistController {

    private final ArtistServiceBean artistServiceBean;
    private final ResourceLoader resourceLoader;


    @Autowired
    public ArtistController(ArtistServiceBean artistServiceBean, ResourceLoader resourceLoader) {
        this.artistServiceBean = artistServiceBean;
        this.resourceLoader = resourceLoader;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String getLibraries() throws TransformerException, IOException {
        String xmlData = artistServiceBean.getAsXml(); // Создайте метод, возвращающий XML

        Resource xslResource = resourceLoader.getResource("classpath:templates/artists.xsl");
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
