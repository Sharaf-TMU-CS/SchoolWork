
/**
 * This class represents a person and their list of friends (first names only),
 * stored as a string with names separated by a space. For this problem, you
 * should complete the following:
 * <p>
 * - Complete the "befriend" method, which adds the given person to the list of
 * friends
 * - Complete the "unfriend" method, which removes a given person from the list of
 * friends
 * <p>
 * This class is tested by PersonTester.java, which will also help you further
 * understand the method definitions.
 */
public class Person
{
    private String firstName;
    private String friendList;
    private int friendCount;

    /**
     * Creates a person with a given name and no friends in their list.
     *
     * @param name the first name of the person of interest
     */
    public Person(String name)
    {
        firstName = name;
        friendList = "";
        friendCount = 0;

    }

    /**
     * Retrieves the names of all of a person's friends.
     *
     * @return a string containing all of the names of a person's friends
     */
    public String getFriendNames()
    {
        return friendList;
    }

    /**
     * Adds a person to the list of friends of this person.
     *
     * @param p the person whose name is to be added to the friend list
     */
    public void befriend(Person p)
    {
        //-----------Start below here. To do: approximate lines of code = 2
        // add (concatenate) the first name of Person p to the String friendList followed by a space " "
        // increment friendCount
        friendList += (p.firstName+" ");
        friendCount++;
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    /**
     * Removes a person from the list of friends of this person.
     *
     * @param p the person whose name is to be removed from the friend list
     */
    public void unfriend(Person p)
    {
        //-----------Start below here. To do: approximate lines of code = 3
        // removes the first name of Person p from the friendList string. Decrement friendCount
        // Hint: use the replace method of class String. Don't forget to remove the space following the first name (see befriend above)
        // e.g. if first name is "xxx" then remove "xxx "
        // Make sure to check if the person is already in the list before decrementing (can use the String method called contains)
        if (friendList.contains(p.firstName)) {
            friendList = friendList.replace(p.firstName+" ","");
            friendCount--;
        }
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    /**
     * Returns the number of friends a person currently has.
     *
     * @return a count of the number of friends the person has
     */
    public int getFriendCount()
    {
        return friendCount;
    }

}
