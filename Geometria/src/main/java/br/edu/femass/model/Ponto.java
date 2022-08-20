//Qual pacote a classe pertence
package br.edu.femass.model;

//Import, caso tenha

import java.util.Objects;

//Classe
public class Ponto {

    //Atributos
    private Double x;
    private Double y;

    //Construtor
    public Ponto(){
        //0D por que é Double. Pode ser 0.0, para Float usamos 0F.
        this.x = 0D;
        this.y = 0D;
    }

    public Ponto(Double x, Double y){
        //0D por que é Double. Pode ser 0.0, para Float usamos 0F.
        this.x = x;
        this.y = y;
    }

    //Métodos
    public String getLocalizacao(){

        if(this.x == 0 && this.y == 0)
            return "Origem";

        if(this.x>0 && this.y>0)
            return "1º Quadrante";

        if(this.x>0 && this.y<0)
            return "4º Quadrante";

        if(this.x<0 && this.y>0)
            return "2º Quadrante";

        if(this.x<0 && this.y<0)
            return "3º Quadrante";

        if(this.x == 0 && this.y != 0.0)
            return "Eixo Y";

        if(this.x != 0.0 && this.y == 0)
            return "Eixo X";

        return "Nulo";
    }

    public Double getDistancia(Ponto p){

        return Math.sqrt(
                Math.pow(p.getX() - this.x, 2) +
                Math.pow(p.getY() - this.y, 2));
    }

    public Double getX(){
        return this.x;
    }

    public Double getY(){
        return this.y;
    }

    //Sobreescrevendo métodos da classe Object
    public boolean equals(Object object){
        Ponto p = (Ponto) object;
        //Declaramos um Ponto p e convertemos o object para o tipo Ponto
        if(p.getX().equals(this.x) && p.getY().equals(this.y)) return true;

        return false;
    }

    public String toString() {
        return "(" + this.x.toString() + ", " + this.y.toString() + ")";
    }
}
