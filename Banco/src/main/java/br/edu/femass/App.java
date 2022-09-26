package br.edu.femass;

import br.edu.femass.dao.DaoCliente;
import br.edu.femass.model.Cliente;
import br.edu.femass.model.Conta;

import java.util.List;

public class App {

    public static void main(String[] args) {
        gerarClientes();
        lerClientes();
    }

    private static void gerarClientes(){
        Cliente cliente = new Cliente("Gabreille", "23779417022");
        DaoCliente dao = new DaoCliente();
        try{
            dao.gravar(cliente);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        Cliente cliente1 = new Cliente("Maria", "70178568058", "Rua 2");
        cliente1.criarConta(0.0);
        cliente1.criarConta(1000.0);
        cliente1.getContas().get(0).creditar(1000.0);
        cliente1.getContas().get(0).creditar(100.0);
        cliente1.getContas().get(0).debitar(1000.0);

        try{
            dao.gravar(cliente1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private static void lerClientes(){
        try{
            List<Cliente> clientes = new DaoCliente().getClientes();
            for(Cliente cliente: clientes){
                System.out.println(cliente);
                for(Conta conta: cliente.getContas()){
                    System.out.println(conta);
                    System.out.println(conta.getHistorico());
                }
            }
        }catch (Exception e){

        }
    }
}
