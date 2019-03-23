package fishtank;
import javax.swing.text.html.parser.Entity;
import java.awt.*;

/**
 * Seaweed.
 */
public class Seaweed extends FishTankEntity {
  /** The font used to draw instances of this class. */
  static Font FONT = new Font("Monospaced", Font.PLAIN, 10);


    /** The number of weed segments. */
    private int l;

    /** Indicates whether the bottom segment is leaning right. */
    boolean leanRight;

    /** My colour. Ah,the vagaries of British vs. US spelling. */
    Color colour;

    static int length;
    /** store the set-in length of the seaweed. */

    int height = l + this.y;

    int update_times = 0;

    /**
     * Constructs a new seaweed item at the specified cursor
     * location (x,y),l segments tall.
     * @param  l  the number of segments this seaweed is tall.
     */
    public Seaweed(int l) {
      length = l;
      this.l  = l;
      colour  =Color.green.darker().darker();
      //add_entity(this.x,this.y);
      //System.out.println(FishTank.getSeaweedEntity(x,y+3));
    }

    public int getLenght() {
      return l;
    }

//    public void add_entity(int x,int y){
//      for(int i = y+1 ; i <= y+l; i++ ){
//        FishTank.add_seaweed_entities(x,i,5);
//        System.out.println(FishTank.getSeaweedEntity(x,i));}
//    }

    /**
     * Draws this fish tank item.  Looks lovely waving in the current, doesn't
     * it?
     *
     * @param  g  the graphics context in which to draw this item.
     */
    void draw(Graphics g) {

     // WWhich way does the first segment lean?
      boolean lR=leanRight;

      for (int i=0;i<l;i++) {// Draw a "/" seaweed segment: even numbered and leaning to the right.
        if (i%2==0)
          if (lR)
            // Draw the string
            drawString(g,"/",x,(-i+y));
      if (i%2==1) // Draw a "/" seaweed segment: odd numbered and leaning to the right.
        if (lR)
          // Draw the string
          drawString(g,"\\",x,(-i+y));
      if (i%2==0) // Draw a "/" seaweed segment: even numbered and leaning to the left.
        if (!lR)
          // Draw the string
          drawString(g,"\\",x,(-i+y));
        if (i%2==1){ // to make a point about comparing to true or false.
         if (!lR)
          // Draw the string for the last kind of leaning of the segment at lcoation  my_curr_row,(-i+my_curr_col)
          drawString(g,"/",x,(-i+y));
        }
      }}
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
        g.drawString(s, x*fm.charWidth('W'), y*fm.getAscent());
      System.out.println("length" + this.l);
    }



    /**
     * Set this item's location.
     * @param a the first coordinate.
     * @param b  the second coordinate.
     */
    public void setLocation(int a,int b) {
      this.x = a;
      this.y = b;
    }

  @Override
  int getX() {
    return x;
  }

  @Override
  int getY() {
    return y;
  }


  /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    public void update() {



        leanRight  =! leanRight;


        for(int i = y+1; i <= y+l;i++){
          if(FishTank.getSeaweedEntity(x,i) == 0){
            l = i-y;
            break;
          }
        }

        update_times ++;

        if(update_times == 200)
        {
            update_times =- 200;
            if(l < length){
                l ++;
            }
        }


    }


    /** This bubble's first coordinate. */
    private int x;
    /** This bubble's second coordinate. */
    private int y;


}
