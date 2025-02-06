package es.unican.ss.clases;



import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        CustomLocalDateSerializer serializer = new CustomLocalDateSerializer();
        ObjectMapper mimapper = new ObjectMapper();



        Aseguradora aseguradora = new Aseguradora();

        Cliente cliente1 = new Cliente("12345678X", "Juan Ortega", "juan@correo.com");
        Cliente cliente2 = new Cliente("12345678F", "Pablo Prieto", "pablo@correo.com");
        Cliente cliente3 = new Cliente("12345678V", "Ana Rodriguez", "ana@correo.com");
        Cliente cliente4 = new Cliente("72350115G", "pepin", "pepin@gmail.com");

        Vehiculo v1 = new Vehiculo("PLL9597",75,false);
        Vehiculo v2 = new Vehiculo("PLX9597",105,true);
        Vehiculo v3 = new Vehiculo("PLX9797",60,false);
        Vehiculo v4 = new Vehiculo("JLL9551",150,true);
        Vehiculo v5 = new Vehiculo("12345-SA",200,false);



        Seguro seguro1 = new TRFranquicia("AAA-123456", LocalDate.of(2001, 12, 31),v1,100);
        Seguro seguro2 = new TodoRiesgo("BBB-123456",LocalDate.of(2020,9,1),v2);
        Seguro seguro3 = new Terceros("CCC-123456", LocalDate.of(2022,7,15),v3);
        Seguro seguro4 = new TodoRiesgo("CCC-324564", LocalDate.of(2014,3,1), v4);
        Seguro seguro5 = new Terceros( "AAA-1111", LocalDate.of(2025,2,5),v5);

        Parte p1 = new Parte(seguro2,350,LocalDate.of(2021,12,31),1);
        Parte p2 = new Parte(seguro3,350,LocalDate.of(2023,5,15),2);

        cliente1.getSeguros().add(seguro1);
        cliente2.getSeguros().add(seguro2);
        cliente2.getSeguros().add(seguro3);
        cliente3.getSeguros().add(seguro4);
        cliente4.getSeguros().add(seguro5);

        cliente2.getPartes().add(p1);
        cliente2.getPartes().add(p2);

        aseguradora.getClientes().add(cliente1);
        aseguradora.getClientes().add(cliente2);
        aseguradora.getClientes().add(cliente3);
        aseguradora.getClientes().add(cliente4);

        try {
            mimapper.writeValue(new File("src/main/resources/Apartado1.json"),aseguradora );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}