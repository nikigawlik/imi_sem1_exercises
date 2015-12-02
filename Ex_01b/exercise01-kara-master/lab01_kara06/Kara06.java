import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kara06 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kara06 extends Kara
{
    /**
     * Act - do whatever the Kara06 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public static final int MAX_LENGTH = 20;
    int length = 1;

    public void act() 
    {
        // Add your action code here.
        putTrail(length++);
        turnRight();
        
        if (length > MAX_LENGTH)
        {
            Greenfoot.stop();
            return;
        }
    }  
    
    public void putTrail(int n)
    {
        for(int i = 0; i < n; i++)
        {
            putLeaf();
            move();
        }
    }
}
