import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kara03 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kara03 extends Kara
{
    /**
     * Act - do whatever the Kara03 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean top = false;
    public void act() 
    {
        if (onLeaf())
        {
            Greenfoot.stop();
            return;
        }
        
        if (treeFront())
        {
            turnLeft();
            move();
            turnRight();
            move();
            top = true;
        }
        else
        if (!treeRight() && top)
        {
            turnRight();
            move();
            turnLeft();
            top = false;
        }
        else
            move();
    }    
}
