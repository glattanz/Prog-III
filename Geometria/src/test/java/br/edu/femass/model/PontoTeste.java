package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PontoTeste {
    @Test
    void testeConstrutorVazio(){
        Ponto p = new Ponto();
        String esperado = "(0.0, 0.0)";

        Assertions.assertEquals(esperado, p.toString());
    }

    @Test
    void testeConstrutorComParametros(){
        Ponto p = new Ponto(1.2, 3.5);
        String esperado = "(1.2, 3.5)";

        Assertions.assertEquals(esperado, p.toString());
    }

    @Test
    void testePrimeiroQuadrante(){
        Ponto p = new Ponto(1.0, 1.0);
        String esperado = "1º Quadrante";

        Assertions.assertEquals(esperado, p.getLocalizacao());
    }

    @Test
    void testeSegundoQuadrante(){
        Ponto p = new Ponto(-1.0, 1.0);
        String esperado = "2º Quadrante";

        Assertions.assertEquals(esperado, p.getLocalizacao());
    }

    @Test
    void testeTerceiroQuadrante(){
        Ponto p = new Ponto(-1.0, -1.0);
        String esperado = "3º Quadrante";

        Assertions.assertEquals(esperado, p.getLocalizacao());
    }

    @Test
    void testeQuartoQuadrante(){
        Ponto p = new Ponto(1.0, -1.0);
        String esperado = "4º Quadrante";

        Assertions.assertEquals(esperado, p.getLocalizacao());
    }

    @Test
    void testeEixoX(){
        Ponto p = new Ponto(1.0, 0.0);
        String esperado = "Eixo X";

        Assertions.assertEquals(esperado, p.getLocalizacao());
    }

    @Test
    void testeEixoY(){
        Ponto p = new Ponto(0.0, 1.0);
        String esperado = "Eixo Y";

        Assertions.assertEquals(esperado, p.getLocalizacao());
    }

    @Test
    void testeDistanciaDoisPontos(){
        Ponto p1 = new Ponto();
        Ponto p2 = new Ponto(0.0, 5.0);
        Double esperado = 5.0;

        Assertions.assertEquals(esperado, p1.getDistancia(p2));
    }

    @Test
    void testeOrigem(){
        Ponto p = new Ponto(0.0, 0.0);
        String esperado = "Origem";

        Assertions.assertEquals(esperado, p.getLocalizacao());
    }

    @Test
    void testEquals(){
        Ponto p1 = new Ponto(1.0, 1.0);
        Ponto p2 = new Ponto(1.0, 1.0);

        Assertions.assertTrue(p1.equals(p2));
    }

}
