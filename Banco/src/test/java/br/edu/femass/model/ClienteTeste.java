package br.edu.femass.model;

import br.edu.femass.utils.CPF;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClienteTeste {


    @Test
    void criarClienteCpfValido() {

        Assertions.assertTrue(CPF.isCPF("32861458666"));
    }

    @Test
    void criarClienteCpfInvalido() {

        Assertions.assertFalse(CPF.isCPF("12345"));
    }

    @Test
    void criarContaGerandoNumero() {
        Cliente cliente = new Cliente("Gabrielle", "32861458666");

        cliente.criarConta(100.0);

        Conta conta = cliente.getContas().get(0);

        Long esperado = 1L;

        Assertions.assertEquals(esperado, conta.getNumero());

    }

}
