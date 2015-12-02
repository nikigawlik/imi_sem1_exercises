import greenfoot.*;

/**
 * This class creates a world for Kara. It contains settings for height and 
 * width of the world and initializes the Actors.
 * 
 * @author Marco Jakob (majakob@gmx.ch)
 * @version 1.3 (2012-07-04)
 */
public class KaraWorld extends World 
{   
    private static final int WORLD_WIDTH = 10;  // Number of horizontal cells
    private static final int WORLD_HEIGHT = 10;  // Number of vertical cells

    private static final int CELL_SIZE = 28; // Size of one cell

    /**
     * Creates a world for Kara.
     */
    public KaraWorld() 
    {
        // Create the new world
        super(WORLD_WIDTH, WORLD_HEIGHT, CELL_SIZE);

        setPaintOrder(Kara.class, Tree.class, Mushroom.class, Leaf.class);
        Greenfoot.setSpeed(20);

        // Initialize actors
        prepare();
    }

    /**
     * Prepare the world, i.e. create all initial actors.
     * 
     * Hint:
     * First create and position all Actors with the mouse in the world.
     * Then right-click on the world and choose 'Save the World'. This will
     * automatically generate the content of this method.
     */
    private void prepare() 
    {
        for(int i = 0; i<WORLD_WIDTH; i++)
        for(int j = 0; j<WORLD_HEIGHT; j++)
        {
            if(i == 0 || j == 0 || i == WORLD_WIDTH-1 || j == WORLD_HEIGHT-1)
                addObject(new Tree(), i, j);
        }
        
        Kara mykara = new MyKara();
        addObject(mykara, WORLD_WIDTH/2, WORLD_HEIGHT/2);
    }
}
