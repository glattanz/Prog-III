package br.edu.femass.model;

import java.util.List;

public class Livro {

    private Long codigo;

    private static Long proximoCodigo = 1L;
    private String titulo;

    private Autor autor;

    private List<Autor> listaAutores = null;

    public Livro(){

    }

    public Livro(String titulo, List<Autor> autores){
        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.titulo = titulo;
//        for (Autor autor: autores) {
//            listaAutores.add(autor);
//        }
        listaAutores.addAll(autores);
    }

    public Livro(String titulo, Autor autor){
        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.titulo = titulo;
        listaAutores.add(autor);
    }

    public static void imprimeLivro(Livro livro){
        System.out.println("Codigo do livro: " + livro.codigo);
        System.out.println("Titulo: " + livro.titulo);
        System.out.println("Informacoes do autor: ");
        Autor.imprimeAutor(livro.autor);
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
