package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SegmentoRetaTeste {

    @Test
    void testeConstrutorCoordenadas(){
        SegmentoReta r = new SegmentoReta(0.0, 0.0, 0.0, 0.0);
        String esperado = "(0.0, 0.0), (0.0, 0.0)";

        Assertions.assertEquals(esperado, r.toString());
    }

    @Test
    void testeConstrutorPontos(){
        Ponto p1 = new Ponto(1.2, 3.5);
        Ponto p2 = new Ponto(3.2, 3.5);
        SegmentoReta r = new SegmentoReta(p1, p2);
        String esperado = "(1.2, 3.5), (3.2, 3.5)";

        Assertions.assertEquals(esperado, r.toString());
    }

    @Test
    void testTamanho() {
        SegmentoReta segmentoReta = new SegmentoReta(0.0, 0.0, 0.0, 5.0);
        Double esperado = 5.0;

        Assertions.assertEquals(esperado, segmentoReta.getTamanho());
    }

    @Test
    void testEquals(){
        SegmentoReta segmentoReta1 = new SegmentoReta(0.0,0.0,0.0,5.0);
        SegmentoReta segmentoReta2 = new SegmentoReta(0.0,0.0,0.0,5.0);

        Assertions.assertTrue(segmentoReta1.equals(segmentoReta2));
    }
}
