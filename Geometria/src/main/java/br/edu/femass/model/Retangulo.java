package br.edu.femass.model;

public class Retangulo extends Quadrado{

    private SegmentoReta altura;

    public Retangulo(SegmentoReta altura, SegmentoReta lado){
        super(lado);
        this.altura = altura;

    }

    public SegmentoReta getAltura(){
        return this.altura;
    }

    //@Override indica que estamos sobrescrevendo o método da superclasse
    @Override
    public Double getArea(){
        return this.altura.getTamanho() * this.lado.getTamanho();
    }

    @Override
    public Double getPerimetro(){
        return this.lado.getTamanho() * 2 + this.altura.getTamanho() * 2;
    }
}
