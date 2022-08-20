package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadradoTeste {

    @Test
    void testArea() {
        //Criamos um quadrado a partir de um segmento de reta que tem tamanho 5
        Quadrado q = new Quadrado(new SegmentoReta(0.0, 0.0, 0.0, 5.0));

        Double esperado = 25.0;

        Assertions.assertEquals(esperado, q.getArea());
    }

    @Test
    void testPerimetro() {
        Quadrado q = new Quadrado(new SegmentoReta(0.0, 0.0, 0.0, 5.0));

        Double esperado = 20.0;

        Assertions.assertEquals(esperado, q.getPerimetro());
    }
}