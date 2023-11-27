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
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
        }
        if(Greenfoot.isKeyDown("right"))
        {
            move(2);
        }
        Eat();
    }
    
    public void Eat()
    {
        if(isTouching(Berry.class))
        {
            removeTouching(Berry.class);
            MyWorld world = (MyWorld) getWorld();
            world.createBerry();
            world.increaseScore();
        }
    }
}
