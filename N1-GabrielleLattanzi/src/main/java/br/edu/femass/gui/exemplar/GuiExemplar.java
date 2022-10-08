package br.edu.femass.gui.exemplar;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GuiExemplar {
    private JPanel jPanelExemplar;
    private JButton botaoCadastrarExemplar;
    private JButton botaoAlterarExemplar;
    public JList listaLivros;

    public GuiExemplar() {

        botaoCadastrarExemplar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(listaLivros.isSelectionEmpty())
                        JOptionPane.showMessageDialog(getjPanelExemplar(), "Preencha todos os campos!");

                    Exemplar exemplar = new Exemplar((Livro) listaLivros.getSelectedValue());
                    new DaoExemplar().save(exemplar);

                    Livro livroSelecionado = (Livro) listaLivros.getSelectedValue();

                    livroSelecionado.setListaExemplaresObjeto(exemplar);

//                    new DaoLivro().update(livroSelecionado);

                    JOptionPane.showMessageDialog(jPanelExemplar, "Exemplar salvo!");


//                   exemplar.getLivro().setQntExemplares((exemplar.getLivro().getQntExemplares()) + 1);


                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        botaoAlterarExemplar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getjPanelExemplar() {
        return jPanelExemplar;
    }
}