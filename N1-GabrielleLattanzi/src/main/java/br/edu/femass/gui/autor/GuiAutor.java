package br.edu.femass.gui.autor;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiAutor {
    private JButton botaoCadastrar;
    private JButton botaoBuscarObras;
    private JList listaAutores;

    private JPanel jPanelAutor;

    public GuiAutor() {
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Abrir a outra janela antes
                GuiCadastrarAutor guiCadastrarAutor = new GuiCadastrarAutor();
                JFrame frame = new JFrame("Cadastrar autor");
                frame.setContentPane(guiCadastrarAutor.getjPanelCadastrarAutor());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

//                try {
//                    Autor autor = new Autor(campoNome.getText(), campoSobrenome.getText(), campoSobrenome.getText());
//                    new DaoAutor().save(autor);
//                }catch (Exception e){
//                    JOptionPane.showMessageDialog(null, e.getMessage());
//                }
//
//                JOptionPane.showMessageDialog(null, "Autor salvo!");
            }
        });

        botaoBuscarObras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getjPanelAutor() {
        return jPanelAutor;
    }

    public static void main(String[] args) {
        GuiAutor guiAutor = new GuiAutor();
        JFrame frame = new JFrame("Autor");
        frame.setContentPane(guiAutor.jPanelAutor);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            //Cria uma nova lista com todos os autores cadastrados no DaoAutor
            List<Autor> autores = new DaoAutor().getAll();
            //Atualiza a lista
            guiAutor.listaAutores.setListData(autores.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //Mantem o layout independente do sistema operacional
        frame.pack();

        frame.setVisible(true);

    }
}
