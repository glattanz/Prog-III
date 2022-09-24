package br.edu.femass.gui.telaInicial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiTelaInicial {
    private JTextField campoUser;
    private JPanel jPanelTelaInicial;
    private JTextField campoSenha;
    private JButton entrarButton;

    public GuiTelaInicial() {
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(campoUser.getText() == "bibliotecario" && campoSenha.getText() == "123"){

                }else if(campoUser.getText() == "atendente" && campoSenha.getText() == "123"){

                }
            }
        });
    }

    public static void main(String[] args) {
        GuiTelaInicial guiTelaInicial = new GuiTelaInicial();
        JFrame frame = new JFrame("Login");
        frame.setContentPane(guiTelaInicial.jPanelTelaInicial);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();

        frame.setVisible(true);
    }
}
