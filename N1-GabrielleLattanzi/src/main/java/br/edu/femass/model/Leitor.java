package br.edu.femass.model;

import java.time.LocalDate;

public class Leitor {

    private Long codigo;
    private static Long proximoCodigo = 1L;
    private String nome;
    private String endereco;
    private String telefone;
    private int prazoMaximoDevolucao;

    public Leitor(){

    }

    public Leitor(String nome, String endereco, String telefone){
        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

//    public void realizarEmprestimo(Livro livro){
//        Emprestimo emprestimo = new Emprestimo(this);
//    }

    public void realizarDevolucao(Emprestimo emprestimo){
        emprestimo.setDataDevolucao(LocalDate.now());

        System.out.println("Devolucao realizada.");
    }

    public void imprimirLeitor(Leitor leitor){
        System.out.println("Nome: " + leitor.nome);
        System.out.println("Endereco: " + leitor.endereco);
        System.out.println("Telefone: " + leitor.telefone);
    }

    public static void setProximoCodigo(Long proximoCodigo) {
        Leitor.proximoCodigo = proximoCodigo;
    }

//    public void imprimirEmprestimo(){
//        System.out.println("INFORMACOES DO EMPRESTIMO: ");
//        //Emprestimo emprestimo = new Emprestimo();
//        System.out.println("Data do emprestimo: " + emprestimo.getDataEmprestimo());
//        System.out.println("Data prevista de devolucao: " + emprestimo.getDataPrevistaDevolucao());
//
//        if(emprestimo.getDataDevolucao() != null){
//            System.out.println("Data de devolucao: " + emprestimo.getDataDevolucao());
//        }
//
//        System.out.println("INFORMACOES DO EXEMPLAR");
//
//
//        System.out.println("INFORMACOES DO LEITOR");
//        this.imprimirLeitor(this);
//    }

    //Getters and Setters
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getPrazoMaximoDevolucao() {
        return prazoMaximoDevolucao;
    }

    public void setPrazoMaximoDevolucao(int prazoMaximoDevolucao) {
        this.prazoMaximoDevolucao = prazoMaximoDevolucao;
    }
}
