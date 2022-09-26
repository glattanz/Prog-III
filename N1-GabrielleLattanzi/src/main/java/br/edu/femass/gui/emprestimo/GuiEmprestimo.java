package br.edu.femass.gui.emprestimo;

import br.edu.femass.model.Emprestimo;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Leitor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiEmprestimo {
    private JPanel jPanelEmprestimo;
    public JList listaAlunos;
    public JList listaProfessores;
    public JList listaExemplares;
    private JButton botaoEmprestimoProfessor;
    private JButton botaoEmprestimoAluno;

    public GuiEmprestimo() {
        botaoEmprestimoAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Emprestimo emprestimo = new Emprestimo((Leitor) listaAlunos.getSelectedValue(), (Exemplar) listaExemplares.getSelectedValue());
                JOptionPane.showMessageDialog(jPanelEmprestimo, "Emprestimo realizado!");
            }
        });
        botaoEmprestimoProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Emprestimo emprestimo = new Emprestimo((Leitor) listaProfessores.getSelectedValue(), (Exemplar) listaExemplares.getSelectedValue());
                JOptionPane.showMessageDialog(jPanelEmprestimo, "Emprestimo realizado!");
            }
        });
    }

    public JPanel getjPanelEmprestimo() {
        return jPanelEmprestimo;
    }
}
