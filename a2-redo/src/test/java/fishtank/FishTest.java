package fishtank;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FishTest {

    /* Note: FishTest is in the package fishtank, so it has access to package
       private attributes.

       Also note: It's *vital* that you name any other test classes
       (ClassName)Test in the same directory as this one is in.
       properly capitalized -- we will be autograding your tests, so make sure
       to follow this naming convention!
     */
    private Fish fish;

    @Before
    public void setUp() {
        TestUtilities.clearWholeFishtank();
        fish = new Fish();
    }

    @Test
    public void testFishBubbles() {
        //Note: This test currently fails, but should pass once you've
      // refactored &
        //fixed the starter code.
        boolean bubbleMade = false;
        for (int i = 0; i < 200; i++) {
            fish.setLocation(5, 10);
            fish.goingRight =
                false; //notice: I can edit package private attributes!
            fish.update();
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
    public void testFishBubblesPobability(){
        boolean cumulative_success = false;
        int c = 0;//record the appearance of the bubble.
        for (int i = 0; i < 1000; i ++){
            fish.setLocation(5,10);
            fish.goingRight = false;
            fish.update();
            FishTankEntity e = FishTank.getEntity(3,10);
            if(e instanceof Bubble){
                c++;
                FishTank.deleteEntity(3,10);
            }
        }
        System.out.println(c);
        if(c >49 && c < 151){
            cumulative_success = true;
        }
        assertTrue(cumulative_success);
    }

    @Test
    public void testFishTurningAroundPobability(){
        boolean cumulative_success = false;
        int c = 0;//record the appearance of the bubble.
        for (int i = 0; i < 1001; i ++){
            fish.setLocation(5,10);
            fish.goingRight = false;
            fish.update();
            if(fish.goingRight){
                c++;
            }
        }
        if(c >49 && c < 151){
        System.out.println(c);
        cumulative_success = true;
        }
        assertTrue(cumulative_success);
    }

    @Test
    public void testFishUpOrDown(){
        boolean cumulative_success = false;
        int c = 0;//record the appearance of the bubble.
        for (int i = 0; i < 1000; i ++){
            fish.setLocation(5,10);
            fish.goingRight = false;
            fish.update();
            if(fish.getY()==9|| fish.getY() == 11){
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
            fish.setLocation(5, 0);
            fish.goingRight = false;
            fish.update();
            if (fish.getY() < 0) {
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
            fish.setLocation(5, 47);
            fish.goingRight = false;
            fish.update();
            if (fish.getY() > 47) {
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
            fish.setLocation(0, 10);
            fish.goingRight = false;
            fish.update();
            if(fish.getX()<0){
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
            fish.setLocation(106, 10);
            fish.goingRight = true;
            fish.update();
            if(fish.getX()>106){
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
            fish.setLocation(6,6);
            fish.goingRight = false;
            fish.update();
            if(FishTank.getEntity(5,6) instanceof Fish){
                collision_ability = false;
                break;
            }
        }
        assertTrue(collision_ability);
    }
}
