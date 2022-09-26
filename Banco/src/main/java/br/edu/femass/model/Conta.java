package br.edu.femass.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

//Para não colocar no JSON algum método/atributo
@JsonIgnoreProperties("historico")

public class Conta {

    private Long numero;
    private Double saldo;
    private Double especial;
    private List<Historico> historicos;

    private static Long proximoNumero = 1L;

    public Conta(){

    }

    public Conta(Double especial){
        this.numero = proximoNumero;
        proximoNumero++;
        this.saldo = 0.0;
        this.especial = especial;
        this.historicos = new ArrayList<Historico>();
    }

    public void debitar(Double valor) {
        if (valor>this.saldo+ this.especial) {
            throw new IllegalArgumentException("Saldo Insuficiente");
        }
        this.saldo-=valor;
        Historico historico = new Historico(valor, TipoLancamento.DEBITO);
        this.historicos.add(historico);
    }

    public void creditar(Double valor) {
        this.saldo+=valor;
        Historico historico = new Historico(valor, TipoLancamento.CREDITO);
        this.historicos.add(historico);
    }

    public String getHistorico() {
        String resp = "";
        for (Historico historico: historicos) {
            resp+=historico.toString() + "\n";
        }

        return resp;
    }

    public Double getEspecial() {
        return especial;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Long getNumero() {
        return numero;
    }

    public List<Historico> getHistoricos() {
        return historicos;
    }

    public void setEspecial(Double especial) {
        this.especial = especial;
    }

    @Override
    public String toString(){
        return this.numero.toString();
    }
}
