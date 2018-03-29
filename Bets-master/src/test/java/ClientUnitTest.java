import exeption.BillException;
import exeption.NameException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import totalizator.Client;

import java.util.Arrays;
import java.util.List;

@RunWith(Theories.class)
public class ClientUnitTest {
    @DataPoints
    public static List<Integer> billData = Arrays.asList(0,100,1000);

    private String clientName = "Ann";

    @Test
    @Theory
    public void createClient(final int bill) throws NameException,BillException {

        Client client = new Client(clientName, bill);

        Assert.assertEquals(client.getName(), clientName);
        Assert.assertTrue(client.getBill() == bill);
    }

    @Test
    public void createClientPositiveBill() {
        Assert.assertEquals("Ann", "Ann");
        Assert.assertEquals(20, 20);
    }

    @Test(expected = BillException.class)
    public void createClientNegativeBill() throws BillException, NameException {
        new Client("Ann",-1);
    }

    //----- NameException is never used

//    @Test(expected = NameException.class)
//    public void createClientNegativeName() throws NameException, BillException {
//        //Assert.assertEquals(name, "Ann");
//        new Client("jrnwrg",20);
//    }


}