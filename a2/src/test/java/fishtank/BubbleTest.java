package fishtank;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {
    private Bubble bubble;

    @Before
    public void setUp() { bubble = new Bubble();
    }

    @Test
    public void testBubbleOutOfBound(){
        boolean outOfRange = true;
        for(int i = 0; i <1001; i++){
            bubble.setLocation(5,0);
            bubble.update();
            if(bubble.exists()){
                outOfRange = false;
            }
        }
        assertTrue(outOfRange);
    }

    @Test
    public void testBubbleShiftProbability(){
        boolean cumulative_success = false;
        int c = 0;//record the appearance of the bubble.
        for (int i = 0; i < 1001; i ++){
            bubble.setLocation(5,10);
            bubble.update();
            if(bubble.getX()== 4 || bubble.getX() == 6){
                c++;
                System.out.println(c);
            }
        }
        if(c >280 && c < 380){
            System.out.println(c);
            cumulative_success = true;
        }
        assertTrue(cumulative_success);

    }

}