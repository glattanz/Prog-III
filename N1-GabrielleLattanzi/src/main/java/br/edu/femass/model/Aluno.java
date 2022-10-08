package br.edu.femass.model;

import br.edu.femass.dao.DaoAluno;

import java.util.List;

public class Aluno extends Leitor{

    private String matricula;

    public Aluno(){

    }

    public Aluno(String nome, String endereco, String telefone, String matricula) throws Exception {
        super(nome, endereco, telefone);
        this.matricula = matricula;
        setPrazoMaximoDevolucao(15);
        proximoId();
    }

    public String getMatricula() {
        return matricula;
    }

    public void proximoId() throws Exception {
        Long maior = 0L;

        List<Aluno> alunos = new DaoAluno().getAll();
        for (Aluno aluno: alunos) {
            if (aluno.getCodigo()>maior) {
                maior = aluno.getCodigo();
                setCodigo(maior + 1);
            }
        }
    }
}
