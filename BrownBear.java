import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrownBear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BrownBear extends Actor
{
    /**
     * Act - do whatever the BrownBear wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("a"))
        {
            move(-2);
        }
        if(Greenfoot.isKeyDown("d"))
        {
            move(2);
        }
    }
    
    public void eat()
    {
        if(isTouching(Berry.class))
        {
            removeTouching(Berry.class);
        }
    }
}
