import java.util.ArrayList;
import java.util.List;
public class TicTacToeModel {

        public static final int SIZE = 3;
        public static final boolean X = true;
        public static final boolean O = false;

        public enum Status {X_WON, O_WON, TIE, UNDECIDED};

        private char[][] grid;
        private boolean turn;
        private Status status;

        private List<TicTacToeView> views;

        public TicTacToeModel() {
            grid = new char[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    grid[i][j] = ' ';
                }
            }
            turn = X;
            status = Status.UNDECIDED;
            views = new ArrayList<>();
        }
          public void addTicTacToeView(TicTacToeView v) {
            views.add(v);
        }

        private void changeTurn() {
            turn = !turn;
        }

        public Status getStatus() {return status;}

        private void updateStatus() {
            int xWonVertical;
            int xWonHorizontal;
            int xWonDiagonal;
            int oWonVertical;
            int oWonHorizontal;
            int oWonDiagonal;

            for (int i = 0; i < SIZE; i++) {
                xWonVertical = 0;
                oWonVertical = 0;
                xWonDiagonal = 0;
                oWonDiagonal = 0;
                for (int j = 0; j < SIZE; j++) {
                    xWonHorizontal = 0;
                    oWonHorizontal = 0;
                    if (grid[i][j] == 'X'){
                        xWonVertical++;
                    }
                    if (grid[i][j] == 'O'){
                        oWonVertical++;
                    }
                    if (grid[j][j] == 'X'){
                        xWonDiagonal++;
                    }
                    if (grid[j][j] == 'O'){
                        oWonDiagonal++;
                    }
                    for (int k = 0; k < SIZE; k++) {
                        if (grid[k][j] == 'X'){
                            xWonHorizontal++;
                        }
                        if (grid[k][j] == 'O'){
                            oWonHorizontal++;
                        }
                    }
                    if (xWonHorizontal == SIZE){
                        status = Status.X_WON;
                    }
                    if (oWonHorizontal == SIZE){
                        status = Status.O_WON;
                    }
                }
                if (xWonVertical == SIZE || xWonDiagonal == SIZE){
                    status = Status.X_WON;
                }
                if (oWonVertical == SIZE || oWonDiagonal == SIZE){
                    status = Status.O_WON;
                }
            }
            //special case (diagonal [2,0],[1,1],[0,2])
            if (grid[2][0] == 'O' && grid[1][1] == 'O' && grid[0][2] == 'O'){
                status = Status.O_WON;
            }
            if (grid[2][0] == 'X' && grid[1][1] == 'X' && grid[0][2] == 'X'){
                status = Status.X_WON;
            }
        }

        public boolean getTurn() {return turn;}

        public void play(int x, int y) {
            if (grid[x][y] != ' ') return;
            grid[x][y] = turn? 'X' : 'O';
            updateStatus();

            for (TicTacToeView v: views) {v.update(new TicTacToeEvent(this, x, y, turn, status));}
            new Dialog(this.status);
            changeTurn();
        }
}

