import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrownBear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BrownBear extends Actor
{
    GreenfootSound bearSound = new GreenfootSound("roaringbear.mp3");
    GreenfootImage[] walkRight = new GreenfootImage[4];
    GreenfootImage[] walkLeft = new GreenfootImage[4];
    
    //Bear facing right
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * Act - do whatever the BrownBear wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public BrownBear()
    {   
        for(int i = 0; i < walkRight.length; i++)
        {
             walkRight[i] = new GreenfootImage("bear_walk/walk" + i + ".png");
             walkRight[i].scale(90, 80);
        }
        setImage(walkRight[0]);
        
        for(int i = 0; i < walkRight.length; i++)
        {
             walkLeft[i] = new GreenfootImage("bear_walk/walk" + i + ".png");
             walkLeft[i].mirrorHorizontally();
             walkLeft[i].scale(90, 80);
        }
        animationTimer.mark();
    
    }
    
    int imageIndex = 0;
    public void animatedBear()
    {
        if(animationTimer.millisElapsed() < 1500)
        {
            return;
        }
        
        if(facing.equals("right"))
        {
            setImage(walkRight[imageIndex]);
            imageIndex = (imageIndex + 1) % walkRight.length;
        }
        else
        {
            setImage(walkLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % walkLeft.length;
        }
    }  
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
            facing = "left";
        }
        if(Greenfoot.isKeyDown("right"))
        {
            move(2);
            facing = "right";
        }
        Eat();
        animatedBear();
    }
    
    public void Eat()
    {
        if(isTouching(Berry.class))
        {
            removeTouching(Berry.class);
            MyWorld world = (MyWorld) getWorld();
            world.createBerry();
            world.increaseScore();
            bearSound.play();
        }
    }
}
