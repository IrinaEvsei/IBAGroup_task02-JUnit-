import exeption.BillException;
import exeption.NameException;
import exeption.SumException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;
import totalizator.Bet;
import totalizator.Client;


@RunWith(Theories.class)
public class BetUnitTest {

    private Client client;
    private Bet bet;
    @Before
    public void setUp() throws BillException, NameException {
        client = new Client("client", 5);
    }
    @Test
    public void createBetPositive() throws SumException {
        bet = new Bet(client, 5, "team");
        Assert.assertEquals(bet.getClient(), client);
        Assert.assertEquals(bet.getSum(),5,0);
        Assert.assertEquals(bet.getTeamName(), "team");

    }
    @Test (expected = SumException.class)
    public void createBetNegative() throws SumException {
        new Bet(client, 5, "team");

    }

    @Test(expected = SumException.class)
    public void checkSumIsNull() throws SumException {
        bet = new Bet(client, 0, "team1");
    }
    @Test(expected = Exception.class)
    public void checkKfsIsNull() {
        bet.setKfc(0);
    }

    @Test
    public void checkMaxKfs() {
        bet.setKfc(100);
        Assert.assertTrue(100 == bet.getKf());
    }


    @Test
    public void checkMinKfs() {
        double k = 100 / 120;
        bet.setKfc(k);
        Assert.assertTrue(k == bet.getKf());
    }

    @Test(expected = Exception.class)
    public void checkKfsMoreThanMax() {
        bet.setKfc(1000);
        Assert.assertTrue(1000 == bet.getKf());
    }

    @Test(expected = Exception.class)
    public void checkNegativeKfs() {
        bet.setKfc(-1);
    }
}