import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import totalizator.Member;

import java.util.Arrays;
import java.util.List;


@RunWith(Theories.class)
public class MemberUnitTest {
    @DataPoints("positive")
    public static List<Integer> winChancePositive = Arrays.asList(0,30,100);
    @DataPoints ("negative")
    public static List<Integer> winChanceNegative = Arrays.asList(-1,101);

    private Member member;

    @Before
    public void setUp(){
        member = new Member("team1",20 );
    }

    @Test
    @Theory
    public  void setPositiveWinChance (@FromDataPoints("positive") Integer positiveProbability) {
        member.setProb(positiveProbability);
        Assert.assertTrue(member.getProb() == positiveProbability);
    }
}
