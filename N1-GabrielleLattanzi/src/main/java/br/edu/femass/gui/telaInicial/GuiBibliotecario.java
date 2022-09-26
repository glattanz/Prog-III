package br.edu.femass.gui.telaInicial;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.gui.autor.GuiCadastrarAutor;
import br.edu.femass.gui.exemplar.GuiExemplar;
import br.edu.femass.gui.livro.GuiCadastrarLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiBibliotecario {
    private JPanel jPanelBibliotecario;
    private JButton botaoCadastrarAutores;
    private JButton incluirAlterarExemplaresButton;
    private JButton botaoCadastrarLivro;
    public JList listaLivros;

    public GuiBibliotecario() {
        botaoCadastrarAutores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiCadastrarAutor guiCadastrarAutor = new GuiCadastrarAutor();
                JFrame frame = new JFrame("Cadastar autor");
                frame.setContentPane(guiCadastrarAutor.getjPanelCadastrarAutor());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                try {
                    List<Autor> autores = new DaoAutor().getAll();
                    guiCadastrarAutor.listaAutores.setListData(autores.toArray());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                frame.pack();

                frame.setVisible(true);
            }
        });
        botaoCadastrarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiCadastrarLivro guiCadastrarLivro = new GuiCadastrarLivro();
                JFrame frame = new JFrame("Cadastrar livro");
                frame.setContentPane(guiCadastrarLivro.getjPanelCadastrarLivro());

                try {
                    List<Autor> autores = new DaoAutor().getAll();
                    guiCadastrarLivro.listaAutores.setListData(autores.toArray());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                frame.pack();

                frame.setVisible(true);
            }
        });

        incluirAlterarExemplaresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiExemplar guiExemplar = new GuiExemplar();
                JFrame frame = new JFrame("Exemplar");
                frame.setContentPane(guiExemplar.getjPanelExemplar());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                try {
                    List<Livro> livros = new DaoLivro().getAll();
                    guiExemplar.listaLivros.setListData(livros.toArray());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                frame.pack();

                frame.setVisible(true);
            }
        });

    }

    public JPanel getjPanelBibliotecario() {
        return jPanelBibliotecario;
    }

    public static void main(String[] args) {
        GuiBibliotecario guiBibliotecario = new GuiBibliotecario();
        JFrame frame = new JFrame("Bibliotecario");
        frame.setContentPane(guiBibliotecario.getjPanelBibliotecario());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try {
            List<Livro> livros = new DaoLivro().getAll();
            guiBibliotecario.listaLivros.setListData(livros.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        frame.pack();
        frame.setVisible(true);
    }
}
