import java.util.ArrayList;
import java.util.Iterator;

import java.lang.*;

/**
 * A class to maintain an arbitrarily long list of notes.
 * Notes are numbered for external reference by a human user.
 * In this version, note numbers start at 0.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class Notebook
{
    // Storage for an arbitrary number of notes.
    private ArrayList<String> notes;

    /**
     * Perform any initialization that is required for the
     * notebook.
     */
    public Notebook()
    {
        notes = new ArrayList<String>();
    }

    /**
     * Store a new note into the notebook.
     * @param note The note to be stored.
     */
    public void storeNote(String note)
    {
        notes.add(note);
    }
    
    public void removeNote(String content)
    {
        /*
         * works, but is not a nice implementation
         *
        
        int n = numberOfNotes();
        
        for(int i = 0; i < n; i++)
        {
            if(notes.get(i).contains(content))
            {
                notes.remove(i--);
                n--;
            }
        }
        
       
        */
        Iterator<String> it = notes.iterator();
        boolean removedSomething = false;
        
        while(it.hasNext())
        {
            if(match(it.next(), content))//(it.next().contains(content))
            {
                it.remove();
                removedSomething = true;
            }
        }
        
        if(!removedSomething)
            System.out.println("Warning!!!: note '" + content + "' was not found and could not be removed.");
        
        
    }
    
    private boolean match(String text, String expression)
    {
        int pos = 0; //position in the string we are searching through
        int exprPos = 0; //position in the string to search for (expression)
        
        //loop through the string
        while(pos <  text.length())
        {
            //Skip all stars, because they are not evaluated as characters, but seen as fall-back-points
            while(expression.charAt(exprPos) == '*')
                exprPos++;
            
            //check if we've succeeded already
            if(exprPos >= expression.length())
                return true;
                
            //see if the current char in our string matches the current char in the expression
            if(text.charAt(pos) == expression.charAt(exprPos) || expression.charAt(exprPos) == '?')
            {
                //Nice! it (still) lines up, so keep going
                exprPos++;
                //check if we've succeeded already
                if(exprPos >= expression.length())
                    return true;
            }
            else
                //Dang! the expression and the string don't line up. Maybe there's a star we can fall back to.
                while(expression.charAt(exprPos) != '*' && exprPos > 0)
                    exprPos--;
                    
            pos++;
        }
        
        //we didn't succeed, which means we failed
        return false;
    }
    
    private boolean matchRegex(String text, String expression)
    {
        //convert expression to tree structure (using class Node)
        Node root = new Node('#');
        Node treePos = root;

        for(int pos = 0; pos < expression.length(); pos++)
        {
            Node left;
            switch (expression.charAt(pos))
            {
                case '(':
                    Node n = new Node('('); //# = grouping
                    treePos.append(n);
                    treePos = n;
                break;
                case ')':
                    while(treePos.content != '(')
                        treePos = treePos.getParent();
                    treePos = treePos.getParent();
                break;
                case '|':
                    if(treePos.content == '#')
                        //in group
                        treePos = treePos.getParent();
                    
                    left = treePos.getLastChild();
                    treePos.removeLastChild();
                    treePos = treePos.append(new Node('|'));
                    treePos.append(left);                    
                break;
                case '?':
                    left = treePos.getLastChild();
                    treePos.removeLastChild();
                    treePos.append(new Node('?')).append(left);
                break;
                case '*':
                    left = treePos.getLastChild();
                    treePos.removeLastChild();
                    treePos.append(new Node('*')).append(left);
                break;
                case '+':
                    left = treePos.getLastChild();
                    treePos.removeLastChild();
                    treePos.append(new Node('+')).append(left);
                break;/*
                case '{':
                    int substr = "";
                    do
                    {
                        pos++;
                        if(expression.charAt(pos) == ',')
                        {
                            
                            substr = ""
                        }
                    }
                    while (expression.charAt(pos) != '}')
                break;*/
                default: 
                    //all characters have to be in a group
                    if(treePos.content == '#')
                        treePos.append(new Node(expression.charAt(pos)));
                    else
                        treePos.append(new Node('#')).append(new Node(expression.charAt(pos)));
                break;
            }
        }
        
        
        
        return false; //TODO
    }
    
    /**
     * @return The number of notes currently in the notebook.
     */
    public int numberOfNotes()
    {
        return notes.size();
    }

    /**
     * Show a note.
     * @param noteNumber The number of the note to be shown.
     */
    public void showNote(int noteNumber)
    {
        if(noteNumber < 0) {
            // This is not a valid note number, so do nothing.
        }
        else if(noteNumber < numberOfNotes()) {
            // This is a valid note number, so we can print it.
            System.out.println(notes.get(noteNumber));
        }
        else {
            // This is not a valid note number, so do nothing.
        }
    }
    
    public void listNotes()
    {
        int number = 0;
        for(String note : notes)
        {
            System.out.println(number++ + " - " + note);   
        }
    }
    
    /**
     * Test the class (debugging)
     */
    public static void test()
    {
        Notebook notebook = new Notebook();
        
        notebook.storeNote("cancelled :(");
        notebook.storeNote("did stuff");
        notebook.storeNote("cancelled :I");
        notebook.storeNote("did more stuff");
        notebook.storeNote("didn't do much");
        notebook.storeNote("cancelled :)");
        notebook.storeNote("stuff again...");
        notebook.storeNote("aaaand... cancelled :D");
        notebook.storeNote("arc");
        notebook.storeNote("abc");
        notebook.storeNote("a cup");
        
        notebook.removeNote("??????");
        
        notebook.removeNote("diddelidoo");
        
        notebook.listNotes();
    }
    
    public static void testExpr()
    {
        Notebook notebook = new Notebook();
        
        //should match
        notebook.storeNote("foobar");
        notebook.storeNote("foo bar");
        notebook.storeNote("football-bar");
        notebook.storeNote("a football-bartender");
        
        //should not match
        notebook.storeNote("barefoot");
        notebook.storeNote("handbags carrots cheese");
        
        
        notebook.removeNote("foo*bar");
        
        notebook.listNotes();
    }
}

















