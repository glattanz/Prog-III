package br.edu.femass.model;

import java.util.PropertyPermission;

public class Professor extends Leitor{

    private String disciplina;

    public Professor(){

    }

    public Professor(String nome, String endereco, String telefone, String disciplina) {
        super(nome, endereco, telefone);
        setPrazoMaximoDevolucao(30);
        setProximoCodigo(this.getCodigo() + 1);
        this.disciplina = disciplina;
    }
}
