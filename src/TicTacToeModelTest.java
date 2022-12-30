import static org.junit.Assert.*;
import org.junit.*;

public class TicTacToeModelTest {

    @Test
    public void initialStatusMustBeUndecided() {
        TicTacToeModel m = new TicTacToeModel();
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
    }

    @Test
    public void testXWonVertical() {
        TicTacToeModel m = new TicTacToeModel();
        m.play(1,0); //x
        m.play(0,0);
        m.play(1,1); //x
        m.play(0,1);
        m.play(1,2); //x
        assertEquals(TicTacToeModel.Status.X_WON, m.getStatus());
    }

    @Test
    public void testOWonVertical() {
        TicTacToeModel m = new TicTacToeModel();
        m.play(1,0);
        m.play(0,0); //o
        m.play(1,1);
        m.play(0,1); //o
        m.play(2,2);
        m.play(0,2); //o
        assertEquals(TicTacToeModel.Status.O_WON, m.getStatus());
    }
    @Test
    public void testXWonHorizontal() {
        TicTacToeModel m = new TicTacToeModel();
        m.play(0,1); //x
        m.play(0,0);
        m.play(1,1); //x
        m.play(1,0);
        m.play(2,1); //x
        assertEquals(TicTacToeModel.Status.X_WON, m.getStatus());
    }

    @Test
    public void testOWonHorizontal() {
        TicTacToeModel m = new TicTacToeModel();
        m.play(0,1);
        m.play(0,0); //o
        m.play(1,1);
        m.play(1,0); //o
        m.play(2,2);
        m.play(2,0); //o
        assertEquals(TicTacToeModel.Status.O_WON, m.getStatus());
    }

    @Test
    public void testXWonDiagonal() {
        TicTacToeModel m = new TicTacToeModel();
        m.play(0,2); //x
        m.play(0,1);
        m.play(1,1); //x
        m.play(1,0);
        m.play(2,0); //x
        assertEquals(TicTacToeModel.Status.X_WON, m.getStatus());
    }

    @Test
    public void testOWonDiagonal() {
        TicTacToeModel m = new TicTacToeModel();
        m.play(0,1);
        m.play(0,0); //o
        m.play(1,0);
        m.play(1,1); //o
        m.play(2,0);
        m.play(2,2); //o
        assertEquals(TicTacToeModel.Status.O_WON, m.getStatus());
    }
}