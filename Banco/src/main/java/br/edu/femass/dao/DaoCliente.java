package br.edu.femass.dao;

//Como é tudo encadeado, ao trazer o Cliente, trazemos todos as outras classes
//Cliente tem uma lista do tipo Conta, que tem uma lista do tipo Histórico, etc...

import br.edu.femass.model.Cliente;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

//DATA ACESS OBJECT
public class DaoCliente {

    //Podemos criar várias instâncias de DaoCliente e a lista vai se manter a mesma
    private static List<Cliente> clientes = new ArrayList<Cliente>();

    public void gravar(Cliente cliente) throws Exception {
        //1º adiciona o objeto na lista
        clientes.add(cliente);

        //2º gera o JSON
        //ObjectMapper objectMapper = new ObjectMapper();
        ObjectMapper objectMapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build()
                //Enum
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(clientes);
        System.out.println(json);

        //3º grava o arquivo em disco
        FileOutputStream out = new FileOutputStream("cliente.json");
        out.write(json.getBytes());
        out.close();
    }

    public List<Cliente> getClientes() throws Exception{
        //1º Ler o arquivo
        FileInputStream in = new FileInputStream("cliente.json");
        //Existe um construtor da classe String que recebe bytes
        String json = new String(in.readAllBytes());

        //2º Converter em objeto
        ObjectMapper objectMapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build()
                //Enum
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //Como estamos usando uma lista tipadas precisamos usar o TypeReference
        //É lista tipada por ser uma lista do tipo cliente
        clientes = objectMapper.readValue(json, new TypeReference<List<Cliente>>(){});

        //3º Devolver a lista de objeto
        return clientes;
    }


}
