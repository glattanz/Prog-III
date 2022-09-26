package br.edu.femass.gui.telaInicial;

import br.edu.femass.dao.*;
import br.edu.femass.gui.emprestimo.GuiEmprestimo;
import br.edu.femass.gui.leitor.GuiLeitor;
import br.edu.femass.model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GuiAtendente {
    private JButton botaoDevolucao;
    private JButton botaoEmprestimo;
    private JButton manterLeitorButton;
    private JPanel jPanelAtendente;
    private JList listaEmprestimos;

    public GuiAtendente() {
        botaoDevolucao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((Emprestimo) listaEmprestimos.getSelectedValue()).setDataDevolucao(LocalDate.now());
                JOptionPane.showMessageDialog(jPanelAtendente, "Empréstimo devolvido!");
            }
        });

        botaoEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiEmprestimo guiEmprestimo = new GuiEmprestimo();
                JFrame frame = new JFrame("Emprestimo");
                frame.setContentPane(guiEmprestimo.getjPanelEmprestimo());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                try {
                    List<Aluno> alunos = new DaoAluno().getAll();
                    guiEmprestimo.listaAlunos.setListData(alunos.toArray());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    List<Professor> professores = new DaoProfessor().getAll();
                    guiEmprestimo.listaProfessores.setListData(professores.toArray());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    List<Exemplar> exemplares = new DaoExemplar().getAll();
                    guiEmprestimo.listaExemplares.setListData(exemplares.toArray());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                frame.pack();
                frame.setVisible(true);
            }
        });

        manterLeitorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiLeitor guiLeitor = new GuiLeitor();
                JFrame frame = new JFrame("Leitores");
                frame.setContentPane(guiLeitor.getjPanelLeitor());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public JPanel getjPanelAtendente() {
        return jPanelAtendente;
    }

    public static void main(String[] args) {
        GuiAtendente guiAtendente = new GuiAtendente();
        JFrame frame = new JFrame("Atendente");
        frame.setContentPane(guiAtendente.getjPanelAtendente());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try {
            List<Emprestimo> emprestimos = new DaoEmprestimo().getAll();
            guiAtendente.listaEmprestimos.setListData(emprestimos.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        frame.pack();
        frame.setVisible(true);
    }
}
