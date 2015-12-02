import java.util.ArrayList;

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
        clubMembers.add(member);
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
}
