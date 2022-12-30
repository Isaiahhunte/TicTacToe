import javax.swing.*;

public class Dialog extends JOptionPane {
        JFrame f;
    Dialog(TicTacToeModel.Status s){
        f = new JFrame();
        if (s == TicTacToeModel.Status.X_WON){
            JOptionPane.showMessageDialog(f,"X Won!");
        }
        if (s == TicTacToeModel.Status.O_WON){
            JOptionPane.showMessageDialog(f,"O Won!");
        }
    }
}
