import java.util.EventObject;
public class TicTacToeEvent extends EventObject {
    private int y;
    private int x;
    private boolean turn;

    private TicTacToeModel.Status status;

    public TicTacToeEvent(TicTacToeModel ticTacToeModel, int x, int y, boolean turn, TicTacToeModel.Status status){
        super(ticTacToeModel);
        this.x = x;
        this.y = y;
        this.turn = turn;
        this.status = status;
    }
    public int getX() {
        return x;
    }

    public boolean isTurn() {
        return turn;
    }

    public int getY() {
        return y;
    }

    public TicTacToeModel.Status getStatus() {
        return status;
    }

}
