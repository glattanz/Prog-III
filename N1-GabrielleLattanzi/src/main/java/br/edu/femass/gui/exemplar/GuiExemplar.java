package br.edu.femass.gui.exemplar;

import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiExemplar {
    private JPanel jPanelExemplar;
    private JButton botaoCadastrarExemplar;
    private JButton botaoAlterarExemplar;
    public JList listaLivros;

    public GuiExemplar() {
        botaoCadastrarExemplar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Exemplar exemplar = new Exemplar((Livro) listaLivros.getSelectedValue());
                JOptionPane.showMessageDialog(jPanelExemplar, "Exemplar salvo!");
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