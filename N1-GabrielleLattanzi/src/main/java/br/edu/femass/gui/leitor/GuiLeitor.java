package br.edu.femass.gui.leitor;

import br.edu.femass.gui.aluno.GuiCadastrarAluno;
import br.edu.femass.gui.professor.GuiCadastrarProfessor;
import br.edu.femass.model.Aluno;
import br.edu.femass.model.Emprestimo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class GuiLeitor {

    private JPanel jPanelLeitor;
    private JButton botaoCadastrarAluno;
    private JButton botaoCadastrarProfessor;
    private JButton botaoAlterarAluno;
    private JButton botaoAlterarProfessor;
    public JList listaAluno;
    public JList listaProfessor;

    public GuiLeitor(){
        botaoCadastrarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiCadastrarAluno guiCadastrarAluno = new GuiCadastrarAluno();
                JFrame frame = new JFrame("Cadastrar aluno");
                frame.setContentPane(guiCadastrarAluno.getjPanelCadastrarAluno());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        botaoCadastrarProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiCadastrarProfessor guiCadastrarProfessor = new GuiCadastrarProfessor();
                JFrame frame = new JFrame("Cadastrar professor");
                frame.setContentPane(guiCadastrarProfessor.getjPanelCadastrarProfessor());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        botaoAlterarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                 try {
//                    List<Aluno> alunos = new DaoAluno().getAll();
//                    guiLeitor.listaAluno.setListData(alunos.toArray());
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
//
//

            }
        });
        botaoAlterarProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                try {
//                    List<Professor> professores = new DaoProfessor().getAll();
//                    guiLeitor.listaProfessor.setListData(professores.toArray());
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
            }
        });
    }

    public JPanel getjPanelLeitor() {
        return jPanelLeitor;
    }

    public static void main(String[] args) {
        GuiLeitor guiLeitor = new GuiLeitor();
        JFrame frame = new JFrame("Leitor");
        frame.setContentPane(guiLeitor.jPanelLeitor);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.pack();

        frame.setVisible(true);

    }
}
