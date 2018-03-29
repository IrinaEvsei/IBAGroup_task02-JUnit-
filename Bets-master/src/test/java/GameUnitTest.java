import exeption.MarginException;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import totalizator.Game;

@RunWith(Theories.class)
public class GameUnitTest {
    @DataPoints("borders")
    public static  double[] border = { 1, 20 };
    @DataPoints("moreThanMaxBorder")
    public static  double[] means = { 21, 20.1};

    private Game game;

    @Before
    public void createGame() throws MarginException {
        game = new Game(10);
    }

    @Test
    @Theory
    public void checkSetMarginBorder(@FromDataPoints("borders") double borders) {
        game.setMargin(borders);
    }

    @Test(expected = MarginException.class )
    public void checkNegativeMargin(){
        game.setMargin(-1);
    }

    @Test(expected = MarginException.class )
    public void checkMarginIsNull(){
        game.setMargin(0);
    }

    @Test(expected = MarginException.class )
    @Theory
    public void checkMarginMoreThanMax(@FromDataPoints("moreThanMaxBorder") double borders){
        game.setMargin(borders);
    }

    @Test
    @Theory
    public void checkGameOnBorderMargin(@FromDataPoints("borders") double borders) throws MarginException {
        Game newGame = new Game(borders);
    }

    @Test(expected  =  MarginException.class )
    public void checkGameOnNegativeMargin() throws MarginException {
        Game newGame = new Game(-1);
    }

    @Test(expected  =  MarginException.class )
    @Theory
    public void checkGameOnMarginMoreThanMax(@FromDataPoints("moreThanMaxBorder") double borders) throws MarginException {
        Game newGame = new Game(borders);
    }

}