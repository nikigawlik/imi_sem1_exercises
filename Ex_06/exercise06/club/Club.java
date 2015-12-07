import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Club
{
    // Define any necessary fields here ...
    private ArrayList<Membership> clubMembers;

    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        // Initialise any fields here ...
        clubMembers = new ArrayList<Membership>();
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        if(search(member.getName()).isEmpty())
            clubMembers.add(member);
        else
            System.out.println("Could not add member. A member with the name \"" + member.getName() + "\" already exists.");
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return clubMembers.size();
    }

    public int numberJoinedInMonth(int month, int year){
    
        int amountOfPeople = 0;
    
        for (Membership member : clubMembers){
            if ((month == member.getMonth()) && (year == member.getYear())){
                amountOfPeople++;
            }
        }
    
        return amountOfPeople;
    }
    
    public void listJoinedInMonth(int month, int year){
        for (Membership member : clubMembers){
            if ((month == member.getMonth()) && (year == member.getYear())){
                System.out.println(member.getName());
            }
        }
    }
    
    @SuppressWarnings("unchecked") //I ain't dealin with that shit
    public void listAllOrdered()
    {
        ArrayList<Membership> sorted = new ArrayList<Membership>(clubMembers);
        Collections.sort(sorted);
        for (Membership member : sorted){
            System.out.println(member);
        }
    }
    
    /**
     * Searches for members with a specific name (ignoring capitalization).
     * @return list of members with that name. Empty list if nothing is found.
     */
    public ArrayList<Membership> search(String name){
        ArrayList<Membership> results = new ArrayList<Membership>();
        for(Membership member : clubMembers)
        {
            if(member.getName().toLowerCase().equals(name.toLowerCase()))
                results.add(member);
        }
        return results;
    }
    
    /**
     * removes members with a specific name from the club.
     */
    public void remove(String name){
        Iterator<Membership> it = clubMembers.iterator();
        while(it.hasNext())
        {
            Membership member = it.next();
        
            if(member.getName().toLowerCase().equals(name.toLowerCase()))
                it.remove();
        }
        
        /*
         * way cleaner version without redundance:
         * 
         * clubMembers.removeAll(search(name));
         * 
         * but the task says we _have_ to use an iterator. :P
         */
    }
    
    
    /**
     * Searches for members who joined in a specific month & year.
     * @return list of members. Empty list if nothing is found.
     */
    public ArrayList<Membership> search(int month, int year){
        ArrayList<Membership> results = new ArrayList<Membership>();
        for(Membership member : clubMembers)
        {
            if(member.getMonth() == month && member.getYear() == year)
                results.add(member);
        }
        return results;
    }
    
    public ArrayList<Membership> remove(int month, int year){
        ArrayList<Membership> result = search(month, year);
        clubMembers.removeAll(result);
        return result;
    }
    
    public String toString()
    {
        //not for the task, just for fun.
        String str = "";
        
        for(Membership member : clubMembers)
            str += member + "\n";
            
        return str.substring(0, str.length() - 1);
    }
}













