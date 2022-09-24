package br.edu.femass.gui.livro;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.gui.autor.GuiAutor;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;

import javax.swing.*;
import java.util.List;

public class GuiConsultarLivros {
    private JList listaLivros;

    private JPanel jPanelConsultarLivros;

    public JPanel getjPanelConsultarLivros() {
        return jPanelConsultarLivros;
    }

    public static void main(String[] args) {
        GuiConsultarLivros guiConsultarLivros = new GuiConsultarLivros();
        JFrame frame = new JFrame("Consultar livros");
        frame.setContentPane(guiConsultarLivros.jPanelConsultarLivros);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            List<Livro> livros = new DaoLivro().getAll();
            guiConsultarLivros.listaLivros.setListData(livros.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        frame.pack();

        frame.setVisible(true);
    }
}
