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

import static org.junit.Assert.assertEquals;

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

//    private Client client1;
//    private Bet bet;
//
//    @Before
//    public void init() throws SumException, BillException, NameException {
//        client1 = new Client("client1", 100.9);
//        bet = new Bet(client1, 8, "team1");
//    }
//
//    @Test
//    public void createBet() throws SumException {
//        Bet bet = new Bet(client1, 8, "team1");
//        assertEquals("client1", bet.getClient().getName());
//        Assert.assertTrue(100.9 == bet.getClient().getBill());
//        Assert.assertTrue(8 == bet.getSum());
//        assertEquals("team1", bet.getTeamName());
//    }
//
//    @Test(expected = SumException.class)
//    public void checkBillAndSum() throws SumException {
//        client1.setBill(3);
//        bet = new Bet(client1, 8, "team1");
//    }
//
//    @Test(expected = SumException.class)
//    public void checkNegativeSum() throws SumException {
//        bet = new Bet(client1, -1, "team1");
//    }
//
//    @Test(expected = SumException.class)
//    public void checkSumIsNull() throws SumException {
//        bet = new Bet(client1, 0, "team1");
//    }
//    @Test(expected = Exception.class)
//    public void checkKfsIsNull() {
//        bet.setKfc(0);
//    }
//    @Test
//    public void checkMaxKfs() {
//        bet.setKfc(100);
//        Assert.assertTrue(100 == bet.getKf());
//    }
//
//
//    @Test
//    public void checkMinKfs() {
//        double k = 100 / 120;
//        bet.setKfc(k);
//        Assert.assertTrue(k == bet.getKf());
//    }
//
//    @Test(expected = Exception.class)
//    public void checkKfsMoreThanMax() {
//        bet.setKfc(1000);
//        Assert.assertTrue(1000 == bet.getKf());
//    }
//
//    @Test(expected = Exception.class)
//    public void checkNegativeKfs() {
//        bet.setKfc(-1);
//    }
}