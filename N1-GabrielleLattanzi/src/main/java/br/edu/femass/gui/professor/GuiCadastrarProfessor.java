package br.edu.femass.gui.professor;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.Aluno;
import br.edu.femass.model.Professor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiCadastrarProfessor {
    private JPanel jPanelCadastrarProfessor;
    private JTextField campoNome;
    private JTextField campoEndereco;
    private JButton salvarButton;
    private JTextField campoTelefone;
    private JTextField campoDisciplina;

    public JPanel getjPanelCadastrarProfessor() {
        return jPanelCadastrarProfessor;
    }

    public GuiCadastrarProfessor() {
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Professor professor = new Professor(campoNome.getText(), campoEndereco.getText(), campoTelefone.getText(), campoDisciplina.getText());
                    new DaoProfessor().save(professor);
                    JOptionPane.showMessageDialog(null, "Professor salvo!");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        GuiCadastrarProfessor guiCadastrarProfessor = new GuiCadastrarProfessor();
        JFrame frame = new JFrame("Cadastar professor");
        frame.setContentPane(guiCadastrarProfessor.jPanelCadastrarProfessor);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();

        frame.setVisible(true);
    }
}
