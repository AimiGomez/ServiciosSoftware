package es.unican.ss.clases;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonDeserializer {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        List<Cliente> clientes;
        try {
            Aseguradora aseguradora = mapper.readValue(new File("src/main/resources/Apartado1.json"), Aseguradora.class);
             clientes = aseguradora.getClientes();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(Cliente c : clientes){
            System.out.println("DNI : " + c.getDni() + " Nombre : " + c.getNombre() + " Total a pagar: " + c.totalSeguros() + "€");
        }
    }


}
