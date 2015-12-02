import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kara02 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kara02 extends Kara
{
    /**
     * Act - do whatever the Kara02 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean inTunnel = false;
    public void act() 
    {   
        if (treeRight() && treeLeft())
        {
            inTunnel = true;
            putLeaf();
        }
        else
        if (inTunnel) //moves out of tunnel
        {
            Greenfoot.stop();
            return;
        }
        
        move();
    }    
}
