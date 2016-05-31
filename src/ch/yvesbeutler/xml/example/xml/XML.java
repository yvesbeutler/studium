package ch.yvesbeutler.xml.example.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.SchemaOutputResolver;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

public interface XML {
    
    public static final String namespaceURL =
        "http://www.ti.bfh.ch/fileadmin/modules/BTI7055-de.xml";
    
    public default void writeXMLdoc (String xmldocfilepath, String xsdfilepath) {
        try {
            JAXBContext context = JAXBContext.newInstance(this.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,
                                   namespaceURL+" "+xsdfilepath);
            marshaller.marshal(this, new File(xmldocfilepath));
            //marshaller.marshal(this, System.out);
            writeXSD(xsdfilepath);
        } catch (Exception e) { e.printStackTrace(); }
    }
    
    public default void writeXSD (String xsdfilepath) {
        class LocalFileSchemaResolver extends SchemaOutputResolver {
            // by the way, this is an inner (local) class ;-)
            private File f;
            LocalFileSchemaResolver (File f) { this.f = f; }
            public Result createOutput (String namespaceURI,
                                        String fileName) throws IOException {
                StreamResult sr = new StreamResult(
                                    new OutputStreamWriter(
                                        new FileOutputStream(fileName), "UTF-8"));
                sr.setSystemId(f.toURI().toURL().toString());
                return sr;
            }
        }
        try {
            JAXBContext context = JAXBContext.newInstance(this.getClass());
            context.generateSchema(new LocalFileSchemaResolver(new File(xsdfilepath)));
        } catch (Exception e) { e.printStackTrace(); }
    }
    
    public static Object xmldoc2object (String xmldocfilepath, Class objectclass) {
        Object object = null;
        try {
            JAXBContext context = JAXBContext.newInstance(objectclass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            object = objectclass.cast(unmarshaller.unmarshal(
                        new BufferedReader(
                            new InputStreamReader(
                                new FileInputStream(xmldocfilepath), "UTF-8"))));
        } catch (Exception e) { e.printStackTrace(); }
        return object;
    }

}