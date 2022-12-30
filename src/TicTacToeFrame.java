import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame implements  TicTacToeView{
    private JButton[][] buttons;
    public TicTacToeFrame() {
        super("Tic Tac toe!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(TicTacToeModel.SIZE, TicTacToeModel.SIZE));

        TicTacToeModel model = new TicTacToeModel();

        model.addTicTacToeView(this);

        buttons = new JButton[TicTacToeModel.SIZE][TicTacToeModel.SIZE];

        TicTacToeController tttc = new TicTacToeController(model);

        for (int i = 0; i < TicTacToeModel.SIZE; i++) {
            for (int j = 0; j < TicTacToeModel.SIZE; j++) {
                JButton b = new JButton("");
                b.setActionCommand(i + "" + j);
                buttons[i][j] = b;
                int x = i;
                int y = j;
                b.addActionListener(e -> model.play(x,y));
                b.addActionListener(tttc);
                this.add(b);
            }
        }
        this.setSize(300,300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TicTacToeFrame();
    }
    @Override
    public void update(TicTacToeEvent e) {
            String label = e.isTurn() ? "X" : "O";
            buttons[e.getX()][e.getY()].setText(label);
    }
}

