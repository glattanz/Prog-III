package br.edu.femass.model;

import br.edu.femass.utils.CPF;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {

    private String nome;
    private String cpf;
    private String endereco;
    private List<Conta> contas;

    public Cliente(String nome, String cpf){
        this.nome = nome;

        //if(CPF.isCPF(cpf)==false){
        //    throw new IllegalArgumentException("CPF inválido");
        //}
        this.cpf = cpf;
        this.contas = new ArrayList<Conta>();
    }

    public Cliente(String nome, String cpf, String endereco){
        this.nome = nome;

        //if(CPF.isCPF(cpf)==false){
        //    throw new IllegalArgumentException("CPF inválido");
        //}
        this.cpf = cpf;
        this.endereco = endereco;
        this.contas = new ArrayList<Conta>();
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + "\nCPF:" + this.cpf;
    }

    @Override
    public boolean equals(Object obj){
        Cliente cliente = (Cliente) obj;
        return cliente.getCpf().equals(this.cpf);
    }

    public void criarConta(Double especial) {
        Conta conta = new Conta(especial);
        this.contas.add(conta);
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public String getNome() {
        return nome;
    }
}
