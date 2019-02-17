package fishtank;
import java.awt.*;

/**
 * A fish.
 */
public class Fish extends FishTankEntity {

    /** How this fish appears on the screen. */
    String appearance;

    /** Indicates whether this fish is moving right. */
    boolean goingRight;

    /** This fish's x-coordinate. */
    int c;
    /** This fish's y-coordinate. */
    private int r;
    /** The colour of this fish. */
    Color colour;


    /**
     * Constructs a new fish.
     */
    public Fish() {
        colour = Color.cyan.darker().darker().darker();
        appearance = "><>";
        goingRight = true;
    }



    /**
     * Set this item's location.
     * @param a the first coordinate.
     * @param b  the second coordinate.
     */
    public void setLocation(int a, int b) {
      c = a;
      r = b;
    }

    int getX() {
        return c;
    }

    int getY() {
        return r;
    }


    /**
     * Causes this fish to blow a bubble.
     */
    protected void blowBubble() {
        if (0<r && r <106 && c > 0 && c< 46 ){
		  if(FishTank.getEntity(c-1,r) == null){
		      Bubble b = new Bubble();
		      b.setLocation(c-1, r);
		      System.out.println((c-1) + " " + r);
		      FishTank.addEntity((c-1), r, b);
		  }
        }
    }



    /**
     * Build and initialize this fish's forward and backward
     * appearances.
     */
    private String reverseAppearance() {
        String reverse = "";
        for (int i=appearance.length()-1; i>=0; i--) {
            switch (appearance.charAt(i)) {
            case ')': reverse += '('; break;
            case '(': reverse += ')'; break;
            case '>': reverse += '<'; break;
            case '<': reverse += '>'; break;
            case '}': reverse += '{'; break;
            case '{': reverse += '}'; break;
            case '[': reverse += ']'; break;
            case ']': reverse += '['; break;
            default: reverse += appearance.charAt(i); break;
            }
        }
        return reverse;
    }



    /**
     * Turns this fish around, causing it to reverse direction.
     */
    protected void turnAround() {
        goingRight = !goingRight;
        if (goingRight) {
            appearance = reverseAppearance();
        } else {
            appearance = reverseAppearance();
        }
    }

    public void setGoingRight(boolean goingRight) {
        this.goingRight = goingRight;
    }

    /** The font used to draw instances of this class. */
    static Font FONT = new Font("Monospaced", Font.PLAIN, 10);


    /**
     * Draws the given string in the given graphics context at
     * at the given cursor location.
     *
     * @param  g  the graphics context in which to draw the string.
     * @param  s  the string to draw.
     * @param  x  the x-coordinate of the string's cursor location.
     * @param  y  the y-coordinate of the string's cursor location.
     */
    void drawString(Graphics g, String s, int x, int y) {
        g.setColor(colour);
        g.setFont(FONT);
        FontMetrics fm = g.getFontMetrics(FONT);
        g.drawString(s, y*fm.charWidth('W'), x*fm.getAscent());
    }



    /**
     * Draws this fish tank item.
     *
     * @param  g  the graphics context in which to draw this item.
     */
    public void draw(Graphics g) {
        drawString(g, appearance, r, c);
    }



    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    public void update() {
        // Move one spot to the right or left.
        if(c < 2 && (!goingRight) ){
            turnAround();
        }else if(c > 103 && goingRight){
            turnAround();
        }

        if (goingRight) {
            if(FishTank.getEntity(c+1,r)== null){
            c += 1;
            if(FishTank.getSeaweedEntity(c,r) != 0)
            {
                FishTank.deleteSeaweedEnitity(c,r);
            }
            }
            else{
                turnAround();
            }
            }
        else{
            if(FishTank.getEntity(c-1,r)== null){
            c -= 1;
                if(FishTank.getSeaweedEntity(c,r) != 0)
                {
                    FishTank.deleteSeaweedEnitity(c,r);
                }
            }
            else{
                turnAround();
            }
        }

        // Figure out whether I blow a bubble.
        double d = Math.random();
        if (d < 0.1) { blowBubble(); }

        // Figure out whether I turn around.
        d = Math.random();
        if (d < 0.1) { turnAround(); }

        // Figure out whether to move up or down, or neither.
		d = Math.random();
        if (d < 0.1) {
            if(r< 47){
            if(FishTank.getEntity(c,r + 1)== null){
            r += 1;}
//            else{
//                turnAround();}
            }
        } else if (d < 0.2) {
            if(r>0) {
                if (FishTank.getEntity(c, r - 1) == null) {
                    r -= 1;
           }
//                else {
//                    turnAround();
                }
            }
        }
    }

