package br.edu.femass.gui.livro;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiCadastrarLivro {
    private JTextField campoTitulo;
    private JPanel jPanelCadastrarLivro;
    private JButton botaoCadastrarLivro;
    public JList listaAutores;
    private JComboBox comboBox1;

    public GuiCadastrarLivro() {
        botaoCadastrarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(campoTitulo.getText().isEmpty() || listaAutores.getSelectedValuesList().isEmpty())
                        JOptionPane.showMessageDialog(getjPanelCadastrarLivro(), "Preencha todos os campos!");

                    Livro livro = new Livro(campoTitulo.getText(), listaAutores.getSelectedValuesList());
                    new DaoLivro().save(livro);

                    JOptionPane.showMessageDialog(jPanelCadastrarLivro, "Livro salvo!");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }



        });
    }

    public JPanel getjPanelCadastrarLivro() {
        return jPanelCadastrarLivro;
    }


}
