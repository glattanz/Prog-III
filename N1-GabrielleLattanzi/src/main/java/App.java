import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.*;

import java.util.List;

public class App {

    public static void main(String[] args) {

        Autor autor = new Autor("Jorge", "Amado", "Brasileiro");

//        List<Autor> autores = null;
//        autores.add(autor);

        Livro livro = new Livro("Sei la", autor);

        DaoAutor daoAutor = new DaoAutor();

        try{
            daoAutor.save(autor);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

       DaoLivro daoLivro = new DaoLivro();

        try{
            daoLivro.save(livro);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
