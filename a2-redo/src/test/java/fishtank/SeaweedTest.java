package fishtank;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SeaweedTest {
    private Seaweed seaweed;
    @Before
    public void setUp() {
        TestUtilities.clearWholeFishtank();
        seaweed = new Seaweed(6);
    }


    @Test
    public void eatLength() {
        boolean eatability = false;
        seaweed.setLocation(5,10);
        for(int i = 0; i<1001;i++){
        Fish fish = new Fish();
        fish.setLocation(6,8);
        fish.goingRight = false;
        fish.update();
        seaweed.update();
        System.out.println(seaweed.getLenght());
        if(seaweed.getLenght() == 1){
            eatability = true;
        }
        }assertTrue(eatability);

    }
}