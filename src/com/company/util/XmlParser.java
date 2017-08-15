package com.company.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.Writer;

/**
 * Created by cic56 on 14.07.2017.
 */
public class XmlParser {
// маршалинг
    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;

    public XmlParser(Class... classesToBeBound) {
        try{
            JAXBContext ctx = JAXBContext.newInstance(classesToBeBound);
            this.marshaller = ctx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING,"UTF-8");
            this.unmarshaller = ctx.createUnmarshaller();
        } catch (JAXBException e) {
            throw  new IllegalArgumentException(e);
        }
    }
    public  <T> T unmarshall(Reader reader){
        try{
            return (T) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            throw new IllegalArgumentException(e);
        }
    }
    public  void marshall(Object instance, Writer writer){
        try {
            marshaller.marshal(instance,writer);
        } catch (JAXBException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
