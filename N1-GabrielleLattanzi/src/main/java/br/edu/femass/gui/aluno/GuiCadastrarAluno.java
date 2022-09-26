package br.edu.femass.gui.aluno;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Aluno;
import br.edu.femass.model.Autor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiCadastrarAluno {
    private JTextField campoNome;
    private JTextField campoMatricula;
    private JTextField campoTelefone;
    private JTextField campoEndereco;
    private JButton botaoSalvar;

    private JPanel jPanelCadastrarAluno;

    public JPanel getjPanelCadastrarAluno() {
        return jPanelCadastrarAluno;
    }

    public GuiCadastrarAluno() {
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Aluno aluno = new Aluno(campoNome.getText(), campoEndereco.getText(), campoTelefone.getText(), campoMatricula.getText());
                    new DaoAluno().save(aluno);
                    JOptionPane.showMessageDialog(null, "Aluno salvo!");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });
    }

    public static void main(String[] args) {
        GuiCadastrarAluno guiCadastrarAluno = new GuiCadastrarAluno();
        JFrame frame = new JFrame("Cadastar aluno");
        frame.setContentPane(guiCadastrarAluno.jPanelCadastrarAluno);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();

        frame.setVisible(true);
    }

}
