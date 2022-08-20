package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RetanguloTeste {

    @Test
    void getArea() {
        Retangulo r = new Retangulo(new SegmentoReta(0.0, 0.0, 0.0, 5.0),
                                    new SegmentoReta(0.0, 0.0, 8.0, 0.0));
        Double esperado = 40.0;

        Assertions.assertEquals(esperado, r.getArea());

    }

    @Test
    void getPerimetro() {
        Retangulo r = new Retangulo(new SegmentoReta(0.0, 0.0, 0.0, 5.0),
                new SegmentoReta(0.0, 0.0, 8.0, 0.0));
        Double esperado = 26.0;

        Assertions.assertEquals(esperado, r.getPerimetro());
    }
}