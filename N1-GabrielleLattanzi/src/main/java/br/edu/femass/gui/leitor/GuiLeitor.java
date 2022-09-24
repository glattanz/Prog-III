package br.edu.femass.gui.leitor;

import br.edu.femass.gui.aluno.GuiCadastrarAluno;
import br.edu.femass.gui.professor.GuiCadastrarProfessor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiLeitor {

    private JPanel jPanelLeitor;
    private JButton botaoCadastrarAluno;
    private JButton botaoCadastrarProfessor;

    public GuiLeitor(){
        botaoCadastrarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiCadastrarAluno guiCadastrarAluno = new GuiCadastrarAluno();
                JFrame frame = new JFrame("Cadastrar aluno");
                frame.setContentPane(guiCadastrarAluno.getjPanelCadastrarAluno());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();

        frame.setVisible(true);

    }
}
