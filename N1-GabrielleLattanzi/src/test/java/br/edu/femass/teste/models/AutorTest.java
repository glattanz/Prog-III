package br.edu.femass.teste.models;

import br.edu.femass.model.Autor;
import br.edu.femass.model.Professor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutorTest {

    @Test
    void criaAutor(){

        Autor autor = new Autor("Nome", "Sobrenome", "Nacionalidade");

        String nomeEsperado = "Nome";
        String sobrenomeEsperado = "Sobrenome";
        String nacionalidadeEsperado = "Nacionalidade";

        Assertions.assertEquals(nomeEsperado, autor.getNome());
        Assertions.assertEquals(sobrenomeEsperado, autor.getSobrenome());
        Assertions.assertEquals(nacionalidadeEsperado, autor.getNacionalidade());

    }

}