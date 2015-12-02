import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kara01 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kara01 extends Kara
{
    /**
     * Act - do whatever the Kara01 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment. 
     */
    int leafs = 0;
    public void act() 
    {
        // Add your action code here.
        if (leafs++ < 10)
        {
            putLeaf();
            move();
        }
        else
            Greenfoot.stop();
    }    
}
