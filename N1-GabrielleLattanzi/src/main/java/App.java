import br.edu.femass.dao.*;
import br.edu.femass.model.*;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        Autor autor = new Autor("Nome", "Sobrenome", "Brasileiro");

        List<Autor> listaAutores = new ArrayList<>();
        listaAutores.add(autor);

        Livro livro = new Livro("Título", listaAutores);

        Aluno aluno = new Aluno("Gabrielle", "Rua J", "22 999999", "123123");

        DaoAluno daoAluno = new DaoAluno();

        try{
            daoAluno.save(aluno);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        Exemplar exemplar = new Exemplar(livro);

        DaoExemplar daoExemplar = new DaoExemplar();

        try{
            daoExemplar.save(exemplar);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        Emprestimo emprestimo = new Emprestimo(aluno, exemplar);

        DaoEmprestimo daoEmprestimo = new DaoEmprestimo();

        try{
            daoEmprestimo.save(emprestimo);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
