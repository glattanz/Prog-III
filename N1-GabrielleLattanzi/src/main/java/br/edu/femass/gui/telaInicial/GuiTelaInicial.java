package br.edu.femass.gui.telaInicial;

import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiTelaInicial {
    public JPanel jPanelTelaInicial;
    private JTextField campoSenha;
    private JButton entrarButton;
    private JComboBox userComboBox;

    public GuiTelaInicial() {
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(userComboBox.getSelectedItem().equals("atendente") && campoSenha.getText().equals("123")){
                    GuiAtendente guiAtendente = new GuiAtendente();
                    JFrame frame = new JFrame("Atendente");
                    frame.setContentPane(guiAtendente.getjPanelAtendente());
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);

                }else if(userComboBox.getSelectedItem().equals("bibliotecario") && campoSenha.getText().equals("123")){
                    GuiBibliotecario guiBibliotecario = new GuiBibliotecario();
                    JFrame frame = new JFrame("Bibliotecario");
                    frame.setContentPane(guiBibliotecario.getjPanelBibliotecario());
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    try {
                        List<Livro> livros = new DaoLivro().getAll();
                        guiBibliotecario.listaLivros.setListData(livros.toArray());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }

                    frame.pack();
                    frame.setVisible(true);

                } else if (userComboBox.getSelectedItem().equals("Selecione um usuário")) {
                    JOptionPane.showMessageDialog(jPanelTelaInicial,"Selecione um usuário!");

                }else if(!(campoSenha.getText().equals("123"))){
                    JOptionPane.showMessageDialog(jPanelTelaInicial,"Senha inválida!");

                }
            }
        });
    }

//    private void createUIComponents() {
//        // TODO: place custom component creation code here
//        imagem = new JLabel(new ImageIcon("imagemTelaInicial.png"));
//    }
}
