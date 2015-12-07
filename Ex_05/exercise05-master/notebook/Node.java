import java.util.ArrayList;

/**
 * Write a description of class Node here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Node
{
    public char content = '('; 
    public ArrayList<Node> children = new ArrayList<Node>();
    private Node parent = null;
    
    public Node(char content)
    {
        this.content = content;
    }
    
    public Node append(Node n)
    {
        children.add(n);
        n.parent = this;
        return n;
    }
    
    public Node getLastChild()
    {
        return children.get(children.size()-1);
    }
    
    public void removeLastChild()
    {
        children.remove(children.size()-1);        
    }
    
    public Node getParent()
    {
        return (parent == null) ? new Node('(') : parent;
    }
}
