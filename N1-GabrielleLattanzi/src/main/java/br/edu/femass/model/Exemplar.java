package br.edu.femass.model;

import br.edu.femass.dao.DaoExemplar;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import java.time.LocalDate;
import java.util.List;

@JsonIdentityInfo
public class Exemplar {

    private Long codigo;
    private LocalDate dataAquisicao;
    private Livro livro;
    public boolean disponivel;

    public Exemplar(){

    }

    public Exemplar(Livro livro) throws Exception {
        this.dataAquisicao = LocalDate.now();
        this.livro = livro;
        proximoId();
        disponivel = true;
        //livro.getListaExemplares().add(this);
    }

    public Long getCodigo() {
        return codigo;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return this.getLivro().getTitulo() + " " + this.getCodigo();
    }

    public void proximoId() throws Exception {
        Long maior = 0L;

        List<Exemplar> exemplares = new DaoExemplar().getAll();
        for (Exemplar exemplar: exemplares) {
            if (exemplar.getCodigo()>maior) {
                maior = exemplar.getCodigo();
                setCodigo(maior + 1);
            }
        }
    }
}
