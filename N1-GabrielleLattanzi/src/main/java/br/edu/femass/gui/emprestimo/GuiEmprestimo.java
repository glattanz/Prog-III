package br.edu.femass.gui.emprestimo;

import javax.swing.*;

public class GuiEmprestimo {
    private JPanel jPanelEmprestimo;
    public JList listaLeitores;
    public JList listaProfessores;
    public JList listaLivros;
    private JButton botaoEmprestimoProfessor;
    private JScrollPane scrollPanelLeitor;
    private JScrollPane scrollPanelLivro;
    private JButton botaoEmprestimoAluno;

    public GuiEmprestimo() {

    }

    public JPanel getjPanelEmprestimo() {
        return jPanelEmprestimo;
    }
}
