package com.company.storage.serializer;

import com.company.model.*;
import com.company.util.XmlParser;
import com.sun.deploy.xml.XMLParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by cic56 on 14.07.2017.
 */
public class XmlStreamSerializer implements StreamSerializer {

   private XmlParser xmlParser;

    public XmlStreamSerializer() {
        this.xmlParser = new XmlParser(Resume.class, ContactType.class, Link.class, ListSection.class, Organization.class, OrganizationSection.class, Section.class, SectionType.class, TextSection.class);
    }

    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try(Writer w = new OutputStreamWriter(os, StandardCharsets.UTF_8)){
            xmlParser.marshall(r,w);
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try(Reader r = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            return xmlParser.unmarshall(r);
        }
    }
}
