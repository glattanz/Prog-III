import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.gui.telaInicial.GuiTelaInicial;
import br.edu.femass.model.Exemplar;

import javax.swing.*;

public class App {

    public static void main(String[] args) throws Exception {

        GuiTelaInicial guiTelaInicial = new GuiTelaInicial();
        JFrame frame = new JFrame("Login");
        frame.setContentPane(guiTelaInicial.jPanelTelaInicial);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();

        frame.setVisible(true);
    }
}
