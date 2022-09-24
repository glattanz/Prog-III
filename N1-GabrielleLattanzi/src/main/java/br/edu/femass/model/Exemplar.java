package br.edu.femass.model;

import java.time.LocalDate;

public class Exemplar {

    private Long codigo;

    private static Long proximoCodigo = 1L;
    private LocalDate dataAquisicao;
    private Livro livro;

    public Exemplar(Livro livro){
        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.dataAquisicao = LocalDate.now();
        this.livro = livro;
    }

    public void imprimeExemplar(){
        System.out.println("INFORMACOES DO EXEMPLAR:");
        System.out.println("Codigo do exemplar:" + this.codigo);
        System.out.println("Data de aquisicao:" + this.dataAquisicao);
        Livro.imprimeLivro(this.livro);
    }

}
