import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MasterKara here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CopyKara extends Kara
{
    /**
     *
     *
     */
    
    public void act() 
    {
        ArrayList<Boolean> leafRow = new ArrayList<Boolean>();
        turnLeft();
        // walk to the left and store in the leafRow variable wether you found a leaf or not
        while(!treeFront())
        {
            move();
            leafRow.add(onLeaf());
        }
        
        // walk back to middle
        turnRight();
        turnRight();
        
        for(int i = 0; i < leafRow.size(); i++)
            move();
            
        // walk to the right and use leafRow to decide wether to put a leaf or not            
        for(int i = leafRow.size()-1; i >= 0; i--)
        {
            move();
            if(leafRow.get(i))
                putLeaf();
        }
        
        turnLeft();
        turnLeft();
        
        for(int i = 0; i < leafRow.size(); i++)
            move();
            
        turnRight();
        if(treeFront())
            Greenfoot.stop();
        else
            move();
    }
}    