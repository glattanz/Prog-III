package br.edu.femass.model;

import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo
public class Livro {

    private Long codigo;
    private String titulo;
    private List<Autor> listaAutores = new ArrayList<>();

    private List<Exemplar> listaExemplares = new ArrayList<>();
    private int qntExemplares = 0;

    public Livro() {
    }

    public Livro(String titulo, List<Autor> autores) throws Exception {
        this.titulo = titulo;
        listaAutores.addAll(autores);
        proximoId();
    }

    @Override
    public String toString() {
        return this.titulo;
    }

    public void proximoId() throws Exception {
        Long maior = 0L;

        List<Livro> livros = new DaoLivro().getAll();
        for (Livro livro : livros) {
            if (livro.getCodigo() > maior) {
                maior = livro.getCodigo();
                setCodigo(maior + 1);
            }
        }
    }

    //Getters and Setters
    public Long getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public List<Autor> getListaAutores() {
        return listaAutores;
    }

    public List<Exemplar> getListaExemplares() {
        return listaExemplares;
    }


    public int getQntExemplares() {
        return qntExemplares;
    }

    public void setQntExemplares(int qntExemplares) {
        this.qntExemplares = qntExemplares;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setListaAutores(List<Autor> listaAutores) {
        this.listaAutores = listaAutores;
    }

    public void setListaExemplares(List<Exemplar> listaExemplares) {
        this.listaExemplares = listaExemplares;
    }

    public void setListaExemplaresObjeto(Exemplar exemplar) {
        this.listaExemplares.add(exemplar);
    }
}
