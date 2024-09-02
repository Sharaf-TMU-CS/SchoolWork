/**
 * A class for a Voting Machine. Complete the following tasks:
 * <p>
 * - Create a constructor
 * - Create accessor methods for the private variables
 * - Create methods for adding a vote for each party
 * - Create a newElection method which resets vote tallies
 * - Create a getWinner method which returns a String indicating who won
 */
public class VotingMachine
{
    /*
     * party1Name and party2Name each store the name of a political party
     * numVotes1 and numVotes2 are used to record number of votes for each political party
     */
    private String party1Name;
    private String party2Name;
    private int numVotes1;
    private int numVotes2;


    /**
     * Create a constructor method that has 2 String arguments which
     * are used to initialize the name of each political party
     * Set the number of votes for each party to 0
     */
    //-----------Start below here. To do: approximate lines of code = 5
    //
    public VotingMachine(String party1, String party2){
        party1Name = party1;
        party2Name = party2;
        numVotes1 = 0;
        numVotes2 = 0;
    }
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    // Create accessor methods for each instance variable (i.e. "getters")
    // These should be called getParty1Name, getParty2Name, getNumVotes1, getNumVotes2
    //-----------Start below here. To do: approximate lines of code = 8
    //
    public String getParty1Name(){
        return party1Name;
    }
    
    public String getParty2Name(){
        return party2Name;
    }

    public int getNumVotes1(){
        return numVotes1;
    }

    public int getNumVotes2(){
        return numVotes2;
    }
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    /**
     * Create a public methods voteParty1() and voteParty2() which adds one vote
     * for each political party 1
     */
    //-----------Start below here. To do: approximate lines of code = 4
    //
    
    public void voteParty1(){
        numVotes1++;
    }

    public void voteParty2(){
        numVotes2++;
    }
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    /**
     * Create a public method newElection() that sets the current number of votes for
     * each political party to 0
     */
    //-----------Start below here. To do: approximate lines of code = 2
    //
    public void newElection(){
        numVotes1 = 0;
        numVotes2 = 0;
    }
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    /**
     * Create a public method getWinner() that returns a String.
     * If party 1 has more votes than party 2 then return the string
     * containing: the name of party 1 followed by " wins the election with "
     * followed by the number of votes for party 1 followed by " votes"
     *
     * If party 2 has more votes than party 1 then return the string
     * containing: the name of party 2 followed by " wins the election with "
     * followed by the number of votes for party 2 followed by " votes"
     *
     * If party 2 has the same votes as party 1 then return the string
     * containing: the name of party 1 followed by " and " followed by
     * the name of party 2 followed by " tied with " followed by the
     * number of votes for party 1 followed by " votes"
     */
    //-----------Start below here. To do: approximate lines of code = 7
    //
    public String getWinner(){
        if (numVotes1 > numVotes2) {
            return party1Name+" wins the election with "+numVotes1+" votes";
        }
        else if (numVotes2 > numVotes1) {
            return party2Name+" wins the election with "+numVotes2+" votes";
        }
        else {
            return party1Name+" and "+party2Name+" tied with "+numVotes1+" votes";
        }
    }
    
    

    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
