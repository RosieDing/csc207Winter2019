package fishtank;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HungryFishTest {

    private HungryFish hungryfish;

    @Before
    public void setUp() {
        TestUtilities.clearWholeFishtank();
        hungryfish = new HungryFish();
    }

    @Test
    public void testFishBubbles() {
        //Note: This test currently fails, but should pass once you've
        // refactored &
        //fixed the starter code.
        boolean bubbleMade = false;
        for (int i = 0; i < 200; i++) {
            hungryfish.setLocation(5, 10);
            hungryfish.goingRight =
                    false; //notice: I can edit package private attributes!
            hungryfish.update();
            //fish should move one tile left and eventually blow a bubble.
            FishTankEntity e = FishTank.getEntity(3, 10);
            if (e instanceof Bubble) {
                bubbleMade = true;
                break;
            }
        }
        //You could also write "assert bubbleMade", but using the JUnit version
        //makes the message much nicer if it fails.
        assertTrue(bubbleMade);
    }

    @Test
    public void testHFishBubblesPobability(){
        boolean cumulative_success = false;
        int c = 0;//record the appearance of the bubble.
        for (int i = 0; i < 1000; i ++){
            hungryfish.setLocation(5,10);
            hungryfish.goingRight = false;
            hungryfish.update();
            FishTankEntity e = FishTank.getEntity(3,10);
            if(e instanceof Bubble){
                c++;
                FishTank.deleteEntity(3,10);
                System.out.println(c);
            }
        }

        if(c >30 && c < 151){
            cumulative_success = true;
        }
        assertTrue(cumulative_success);
    }


    @Test
    public void testFishUpOrDown(){
        boolean cumulative_success = false;
        int c = 0;//record the appearance of the bubble.
        for (int i = 0; i < 1000; i ++){
            hungryfish.setLocation(5,10);
            hungryfish.goingRight = false;
            hungryfish.update();
            if(hungryfish.getY()==9|| hungryfish.getY() == 11){
                c++;
                System.out.println(c);
            }
        }
        //System.out.println(c);
        if(c >150 && c < 250){
            cumulative_success = true;
        }
        assertTrue(cumulative_success);
    }

    @Test
    public void testFishUppperBound(){
        boolean keepshorizontal = true;
        for (int i = 0; i < 200; i++) {
            hungryfish.setLocation(5, 0);
            hungryfish.goingRight = false;
            hungryfish.update();
            if (hungryfish.getY() < 0) {
                keepshorizontal = false;
                break;
            }
        }
        assertTrue(keepshorizontal);
    }

    @Test
    public void testFishLowerBound(){
        boolean keepshorizontal = true;
        for (int i = 0; i < 200; i++) {
            hungryfish.setLocation(5, 47);
            hungryfish.goingRight = false;
            hungryfish.update();
            if (hungryfish.getY() > 47) {
                keepshorizontal = false;
                break;
            }
        }
        assertTrue(keepshorizontal);
    }

    @Test
    public void testLeftBound(){
        boolean keepshorizontal = true;
        for (int i = 0; i < 200; i++) {
            hungryfish.setLocation(0, 10);
            hungryfish.goingRight = false;
            hungryfish.update();
            if(hungryfish.getX()<0){
                keepshorizontal = false;
                break;
            }
        }
        assertTrue(keepshorizontal);
    }

    @Test
    public void testRightBound(){
        boolean keepshorizontal = true;
        for (int i = 0; i < 200; i++) {
            hungryfish.setLocation(106, 10);
            hungryfish.goingRight = true;
            hungryfish.update();
            if(hungryfish.getX()>106){
                keepshorizontal = false;
                break;
            }
        }
        assertTrue(keepshorizontal);
    }

    @Test
    public void testCollision(){
        Seaweed s = new Seaweed(5);
        s.setLocation(5,6);
        boolean collision_ability = true;
        for(int i = 0; i< 200; i++){
            hungryfish.setLocation(6,6);
            hungryfish.goingRight = false;
            hungryfish.update();
            if(FishTank.getEntity(5,6) instanceof Fish){
                collision_ability = false;
                break;
            }
        }
        assertTrue(collision_ability);
    }
}