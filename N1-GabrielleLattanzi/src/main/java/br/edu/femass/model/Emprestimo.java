package br.edu.femass.model;

import javax.crypto.ExemptionMechanism;
import java.time.LocalDate;

public class Emprestimo {

    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao = null;
    private Exemplar exemplar;
    private Leitor leitor;
    private Livro livro;
    private String teste;


    public Emprestimo(){

    }

    public Emprestimo(Leitor leitor, Exemplar exemplar){
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevistaDevolucao = LocalDate.now().plusDays(leitor.getPrazoMaximoDevolucao());
        this.leitor = leitor;
        this.exemplar = exemplar;
        this.livro = exemplar.getLivro();
        this.teste = this.leitor + " " +  this.livro + " " + this.dataEmprestimo + " " + this.exemplar.getCodigo();
    }

    public void realizarDevolucao(){
        this.dataDevolucao = LocalDate.now();
    }


    //Getters and Setters
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    @Override
    public String toString() {
        return livro.getTitulo();
    }

}
