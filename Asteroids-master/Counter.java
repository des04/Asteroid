import greenfoot.*;

/**
 * A Counter class that allows you to display a numerical value on screen.
 * 
 * The Counter is an actor, so you will need to create it, and then add it to
 * the world in Greenfoot.  If you keep a reference to the Counter then you
 * can adjust its value.
 * 
 * @author Neil Brown and Michael Kölling 
 * @version 1.0
 */
public class Counter extends Actor
{
    private static final Color TRANSPARENT = new Color(0,0,0,0);
    
    private GreenfootImage background;
    
    private int value;
    
    private int target;
    
    private String prefix;

    /**
     * A constructor for objects of class Counter
     * 
     * @param prefix is the words that come before the score is displayed
     * @return An object of type Counter
     */
    public Counter(String prefix)
    {
        background = getImage();  // get image from class
        value = 0;
        target = 0;
        this.prefix = prefix;
        updateImage();
    }
    
    /**
     * the act method for counter, this is the main function of the Counter
     * class
     * 
     * @param None If there is we have an issue
     * @return Ditto
     * 
     * Animate the display to count up (or down) to the current target value.
     */
    public void act() 
    {
        if (value < target) 
        {
            value++;
            
            updateImage();
        }
        else if (value > target) 
        {
            value--;
            
            updateImage();
        }
    }

    /**
     * add adds the score to the game
     * 
     * @param There is an int parameter called score that represents the score
     * @return Nothing is returned
     * 
     * Add a new score to the current counter value.  This will animate
     * the counter over consecutive frames until it reaches the new value.
     */
    public void add(int score)
    {
        target += score;
    }
    
    /**
     * getValue returns a value that affects the score
     * 
     * @param None There are no parameters
     * @return target is returned. target represents the score recieved from
     * schooting asteroids
     * 
     * Return the current counter value.
     */
    public int getValue()
    {
        return target;
    }

    /**
     * updateImage updates the screen to show the score
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     * 
     * Update the image on screen to show the current value.
     */
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage(prefix + value, 22, Color.BLACK, TRANSPARENT);
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }
        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, (image.getHeight()-text.getHeight())/2);
        
        setImage(image);
    }
}
