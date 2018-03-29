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
}