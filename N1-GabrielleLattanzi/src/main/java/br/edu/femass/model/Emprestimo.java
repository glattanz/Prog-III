package br.edu.femass.model;

import javax.crypto.ExemptionMechanism;
import java.time.LocalDate;

public class Emprestimo {

    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao = null;
    private Exemplar exemplar;
    private String nomeEmprestimo;

    public Emprestimo(){

    }

    public Emprestimo(Leitor leitor, Exemplar exemplar){
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevistaDevolucao = LocalDate.now().plusDays(leitor.getPrazoMaximoDevolucao());
        this.exemplar = exemplar;
        //this.nomeEmprestimo = leitor.getNome() + " - " + exemplar.getLivro().getTitulo() + " - " + this.dataEmprestimo + " - Cód: " + this.exemplar.getCodigo();
    }

    public void realizarDevolucao(){
        this.dataDevolucao = LocalDate.now();
    }


    //Getters and Setters
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
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

    public String getNomeEmprestimo() {
        return nomeEmprestimo;
    }

    @Override
    public String toString() {
        return exemplar.getLivro().getTitulo() ;
    }

}
