package br.edu.femass.model;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoProfessor;

import java.util.List;
import java.util.PropertyPermission;

public class Professor extends Leitor{

    private String disciplina;

    public Professor(){

    }

    public Professor(String nome, String endereco, String telefone, String disciplina) throws Exception {
        super(nome, endereco, telefone);
        this.disciplina = disciplina;
        setPrazoMaximoDevolucao(30);
        proximoId();
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void proximoId() throws Exception {
        Long maior = 0L;

        List<Professor> professores = new DaoProfessor().getAll();
        for (Professor professor: professores) {
            if (professor.getCodigo()>maior) {
                maior = professor.getCodigo();
                setCodigo(maior + 1);
            }
        }
    }
}
