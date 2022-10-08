package br.edu.femass.teste.models;

import br.edu.femass.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmprestimoTest {

    @Test
    void criarEmprestimo() throws Exception {

        Leitor leitor = new Leitor("Nome", "Endereço", "Telefone");
        Exemplar exemplar = new Exemplar(new Livro());
        Emprestimo emprestimo = new Emprestimo(leitor, exemplar);

        LocalDate dataEmprestimoEsperado = LocalDate.now();
        String exemplarEsperado = exemplar.toString();
        LocalDate dataDevolucaoEsperado = null;
        LocalDate dataPrevistaDevolucaoEsperado = LocalDate.now();

        Assertions.assertEquals(dataEmprestimoEsperado, emprestimo.getDataEmprestimo());
        Assertions.assertEquals(exemplarEsperado, emprestimo.getExemplar().toString());
        Assertions.assertEquals(dataDevolucaoEsperado, emprestimo.getDataDevolucao());
        Assertions.assertEquals(dataPrevistaDevolucaoEsperado, emprestimo.getDataPrevistaDevolucao());

    }

    @Test
    void criarEmprestimoAluno() throws Exception {

        Aluno aluno = new Aluno("Nome", "Endereço", "Telefone", "Matrícula");
        Exemplar exemplar = new Exemplar(new Livro());
        Emprestimo emprestimo = new Emprestimo(aluno, exemplar);

        LocalDate dataEmprestimoEsperado = LocalDate.now();
        String exemplarEsperado = exemplar.toString();
        LocalDate dataDevolucaoEsperado = null;
        LocalDate dataPrevistaDevolucaoEsperado = LocalDate.now().plusDays(15);

        Assertions.assertEquals(dataEmprestimoEsperado, emprestimo.getDataEmprestimo());
        Assertions.assertEquals(exemplarEsperado, emprestimo.getExemplar().toString());
        Assertions.assertEquals(dataDevolucaoEsperado, emprestimo.getDataDevolucao());
        Assertions.assertEquals(dataPrevistaDevolucaoEsperado, emprestimo.getDataPrevistaDevolucao());

    }

    @Test
    void criarEmprestimoProfessor() throws Exception {

        Professor professor = new Professor("Nome", "Endereço", "Telefone", "Matrícula");
        Exemplar exemplar = new Exemplar(new Livro());
        Emprestimo emprestimo = new Emprestimo(professor, exemplar);

        LocalDate dataEmprestimoEsperado = LocalDate.now();
        String exemplarEsperado = exemplar.toString();
        LocalDate dataDevolucaoEsperado = null;
        LocalDate dataPrevistaDevolucaoEsperado = LocalDate.now().plusDays(30);

        Assertions.assertEquals(dataEmprestimoEsperado, emprestimo.getDataEmprestimo());
        Assertions.assertEquals(exemplarEsperado, emprestimo.getExemplar().toString());
        Assertions.assertEquals(dataDevolucaoEsperado, emprestimo.getDataDevolucao());
        Assertions.assertEquals(dataPrevistaDevolucaoEsperado, emprestimo.getDataPrevistaDevolucao());

    }

    @Test
    void devolucao(){

    }

    @Test
    void teste() throws Exception {

        Autor autor = new Autor("Nome", "Sobrenome", "Nacionalidade");
        List<Autor> autores = new ArrayList<>();

        Professor professor = new Professor("Nome", "Endereço", "Telefone", "Matrícula");
        Exemplar exemplar = new Exemplar(new Livro("Título", autores));
        Emprestimo emprestimo = new Emprestimo(professor, exemplar);

        String esperado = "";

        Assertions.assertEquals(esperado, emprestimo.toString());
    }

    
}