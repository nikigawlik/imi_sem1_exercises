import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kara05 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kara05 extends Kara
{
    /**
     * Act - do whatever the Kara05 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     boolean lookingEast = true;
    
    
    public void act() 
    {
        if (onLeaf())
            removeLeaf();
        else
            putLeaf();
            
            
        if (!treeFront())
        {
            move();
        }
        else
        {
            if (lookingEast)
            {
                if (treeRight())
                {
                    Greenfoot.stop();
                    return;
                }
                turnRight();
                move();
                turnRight();
                lookingEast = false;
            }
            else
            {
                if (treeLeft())
                {
                    Greenfoot.stop();
                    return;
                }
                turnLeft();
                move();
                turnLeft();
                lookingEast = true;
            }
        }
    }
}
