package br.edu.femass.teste;

import br.edu.femass.model.Cliente;
import br.edu.femass.model.Conta;

public class ContaTest {

    public static void main(String[] args) {
        Cliente c = new Cliente("Gabrielle", "98765432213");
        System.out.println("Imprimindo dados do cliente: " + c.toString());

        c.criarConta(0.0);
        c.criarConta(1500.0);

        System.out.println("==Imprimindo as contas do Cliente==");
        for (Conta conta: c.getContas()){
            System.out.println("Número: " + conta.toString());
        }

        Conta conta = c.getContas().get(0);
        try{
            conta.creditar(1000.0);
            conta.debitar(120.0);
            conta.debitar(3000.0);
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Saldo da conta:" + conta.getSaldo());
        System.out.println("Histórico de operações:\n" + conta.getHistorico());


    }
}
