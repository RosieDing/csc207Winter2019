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

}