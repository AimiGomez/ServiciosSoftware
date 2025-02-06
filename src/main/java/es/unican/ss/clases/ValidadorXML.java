package es.unican.ss.clases;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class ValidadorXML {
    public static void main(String[] args) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("src/main/resources/Aseguradora.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File("src/main/resources/Apartado3.xml")));
            System.out.println("El XML es válido.");
        } catch (Exception e) {
            System.out.println("El XML no es válido: " + e.getMessage());
        }
    }
}

