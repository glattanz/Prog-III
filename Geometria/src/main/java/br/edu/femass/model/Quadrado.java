package br.edu.femass.model;

public class Quadrado {

    //Como todos os lados do quadrado são iguais, só precisamos de um para os cálculos
    protected SegmentoReta lado;

    public Quadrado(SegmentoReta lado){
        this.lado = lado;
    }

    //Método do tipo SegmentoReta porque o lado é um segmento de reta
    public SegmentoReta getLado(){
        return lado;
    }

    public Double getArea(){
        //Como lado é um segmento de reta (0.0, 0.0), usamos o getTamanho() para saber o tamanho desse segmento
        return Math.pow(this.lado.getTamanho(),2);
    }

    public Double getPerimetro(){
        return this.lado.getTamanho() * 4;
    }
}
