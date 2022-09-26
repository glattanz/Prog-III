package br.edu.femass.teste.models;

import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LivroTest {

    @Test
    void criarLivroUmAutor(){

        Autor autor = new Autor("Nome", "Sobrenome", "Nacionalidade");
        List<Autor> listaAutores = new ArrayList<>();
        listaAutores.add(autor);
        Livro livro = new Livro("Título", listaAutores);

        String tituloEsperado = "Título";
        String nomeAutorEsperado = "Nome";
        String sobrenomeAutorEsperado = "Sobrenome";
        String nacionalidadeAutorEsperado = "Nacionalidade";

        Assertions.assertEquals(tituloEsperado, livro.getTitulo());
        Assertions.assertEquals(nomeAutorEsperado, livro.getListaAutores().get(0).getNome());
        Assertions.assertEquals(sobrenomeAutorEsperado, livro.getListaAutores().get(0).getSobrenome());
        Assertions.assertEquals(nacionalidadeAutorEsperado, livro.getListaAutores().get(0).getNacionalidade());

    }

    @Test
    void criarLivroVariosAutores(){

        Autor autor1 = new Autor("Nome", "Sobrenome", "Nacionalidade");
        Autor autor2 = new Autor("Nome", "Sobrenome", "Nacionalidade");
        List<Autor> listaAutores = new ArrayList<>();
        listaAutores.add(autor1);
        listaAutores.add(autor2);
        Livro livro = new Livro("Título", listaAutores);

        String tituloEsperado = "Título";
        String nomeAutor1Esperado = "Nome";
        String sobrenomeAutor1Esperado = "Sobrenome";
        String nacionalidadeAutor1Esperado = "Nacionalidade";
        String nomeAutor2Esperado = "Nome";
        String sobrenomeAutor2Esperado = "Sobrenome";
        String nacionalidadeAutor2Esperado = "Nacionalidade";

        Assertions.assertEquals(tituloEsperado, livro.getTitulo());
        Assertions.assertEquals(nomeAutor1Esperado, livro.getListaAutores().get(0).getNome());
        Assertions.assertEquals(sobrenomeAutor1Esperado, livro.getListaAutores().get(0).getSobrenome());
        Assertions.assertEquals(nacionalidadeAutor1Esperado, livro.getListaAutores().get(0).getNacionalidade());
        Assertions.assertEquals(nomeAutor2Esperado, livro.getListaAutores().get(1).getNome());
        Assertions.assertEquals(sobrenomeAutor2Esperado, livro.getListaAutores().get(1).getSobrenome());
        Assertions.assertEquals(nacionalidadeAutor2Esperado, livro.getListaAutores().get(1).getNacionalidade());

    }
}