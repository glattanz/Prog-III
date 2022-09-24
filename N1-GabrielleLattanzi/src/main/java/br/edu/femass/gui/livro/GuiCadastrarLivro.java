package br.edu.femass.gui.livro;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiCadastrarLivro {
    private JTextField campoTitulo;
    public JComboBox comboBoxAutores;
    private JPanel jPanelCadastrarLivro;
    private JButton botaoCadastrarLivro;
    public JList listaAutores;

    public GuiCadastrarLivro() {
        botaoCadastrarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
//                    do{
//                        JOptionPane.showMessageDialog(jPanelCadastrarLivro, "Selecione um autor");
//                    }while(listaAutores.getSelectedValue() == null);

                    if(listaAutores.getSelectedValuesList() == null){
                        JOptionPane.showMessageDialog(jPanelCadastrarLivro, "Selecione um autor");
                    }

                    //Livro livro = new Livro(campoTitulo.getText(), (Autor) comboBoxAutores.getSelectedItem());

                    Livro livro = new Livro(campoTitulo.getText(), listaAutores.getSelectedValuesList());
                    new DaoLivro().save(livro);

                    JOptionPane.showMessageDialog(jPanelCadastrarLivro, "Livro salvo!");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public JPanel getjPanelCadastrarLivro() {
        return jPanelCadastrarLivro;
    }

    public static void main(String[] args) {
        GuiCadastrarLivro guiCadastrarLivro = new GuiCadastrarLivro();
        JFrame frame = new JFrame("Cadastrar livro");
        frame.setContentPane(guiCadastrarLivro.jPanelCadastrarLivro);

        try {
            //Cria uma nova lista com todos os autores cadastrados no DaoAutor
            List<Autor> autores = new DaoAutor().getAll();
            //Atualiza a lista
            guiCadastrarLivro.listaAutores.setListData(autores.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();

        frame.setVisible(true);
    }
}
