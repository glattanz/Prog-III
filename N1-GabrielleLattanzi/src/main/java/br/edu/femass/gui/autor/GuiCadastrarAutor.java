package br.edu.femass.gui.autor;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.gui.livro.GuiCadastrarLivro;
import br.edu.femass.model.Autor;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GuiCadastrarAutor {
    private JPanel jPanelCadastrarAutor;
    private JTextField campoNome;
    private JTextField campoSobrenome;
    private JTextField campoNacionalidade;
    private JButton botaoSalvar;

    GuiCadastrarLivro guiCadastrarLivro = new GuiCadastrarLivro();

    public GuiCadastrarAutor() {

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Autor autor = new Autor(campoNome.getText(), campoSobrenome.getText(), campoNacionalidade.getText());
                    new DaoAutor().save(autor);

                    JOptionPane.showMessageDialog(jPanelCadastrarAutor, "Autor salvo!");

                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        //Painel
        GuiCadastrarAutor guiCadastrarAutor = new GuiCadastrarAutor();
        //JFrame
        JFrame frame = new JFrame("Cadastar autor");
        //Dentro do JFrame colocamos o jPanelAutor, que esta no form GuiAutor
        frame.setContentPane(guiCadastrarAutor.jPanelCadastrarAutor);

        //Configuração do botão de fechar
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Mantem o layout independente do sistema operacional
        frame.pack();

        frame.setVisible(true);
    }

    public JPanel getjPanelCadastrarAutor() {
        return jPanelCadastrarAutor;
    }

}
