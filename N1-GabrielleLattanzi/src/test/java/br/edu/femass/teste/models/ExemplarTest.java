package br.edu.femass.teste.models;

import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ExemplarTest {

    @Test
    void criarExemplar() throws Exception {

        Exemplar exemplar = new Exemplar(new Livro());

        LocalDate dataAquisicaoEsperado = LocalDate.now();

        Assertions.assertEquals(dataAquisicaoEsperado, exemplar.getDataAquisicao());

    }
    
}