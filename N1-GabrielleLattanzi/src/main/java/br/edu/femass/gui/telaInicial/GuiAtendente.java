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
                    List<Professor> professores = new DaoProfessor().getAll();
                    List<Leitor> leitores = new ArrayList<>();
                    leitores.addAll(alunos);
                    leitores.addAll(professores);
                    guiEmprestimo.listaLeitores.setListData(leitores.toArray());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    List<Livro> livros = new DaoLivro().getAll();
                    List<Livro> livrosDisponiveis = new ArrayList<>();
                    for (Livro livro : livros) {
                        if(livro.getQntExemplares() > 0){
                            livrosDisponiveis.add(livro);
                        }
                    }

                    guiEmprestimo.listaLivros.setListData(livrosDisponiveis.toArray());
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
}
