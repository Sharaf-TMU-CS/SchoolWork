/**
 * Complete the class below which stores information about a Letter, where lines are stored in an ArrayList.
 * You are to complete the following:
 *
 * - Create an addLine method which takes in a String and appends it to the end of the ArrayList holding the letter
 * - Create a getText method which returns a String which has all the text in the letter
 * - Create a getNumberOfLines method which returns the number of lines currently in the letter
 * - Create a removeLine method which removes the line in the letter with the given index (note that indexing starts with 1 for the input)
 *
 */

import java.util.ArrayList;

public class Letter
{
    private String sender;
    private String recipient;
    private ArrayList<String> lines;    // The actual contents (body) of the letter, each line stored individually
    private int addedLines;
    /**
     * Create a constructor method with 2 parameters, each of type String, one to initialize the
     * sender and one to initialize the recipient.
     * initialize lines to a new array list, initially empty
     */

    public Letter(String sender, String recipient)
    {
        this.sender = sender;
        this.recipient = recipient;
        lines = new ArrayList<String>();
        addedLines = 0;
    }

    /**
     * Create a public method void addLine(String line) that adds a new line to the letter.
     * i.e. adds the given new line to the array list
     */
    //-----------Start below here. To do: approximate lines of code = 2
    //
    public void addLine(String line) {
        lines.add(line);
        addedLines++;
    }
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    /**
     * Create a public method String getText() that returns a String containing:
     * "Dear " followed by the recipient name followed by ":\n\n" followed
     * by the text (body) of the letter followed by "\nSincerely,\n" followed by the
     * sender name. Also make sure to add a "\n" to the end of each line in array list lines
     */
    //-----------Start below here. To do: approximate lines of code = 7
    //
    public String getText() {
        String text = "Dear " + recipient + ":\n\n";
        for (int i=0; i<lines.size(); i++) {
            text += (lines.get(i) + "\n");
        }
        text += "\nSincerely,\n" + sender;
        return text;
    }
    
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.


    /**
     * Create a public method getNumberOfLines() that returns the number of lines that were explicitly added to the letter
     * using the addLines() method
     */
    //-----------Start below here. To do: approximate lines of code = 2
    //
    public int getNumberOfLines() {
        return addedLines;
    }
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    // Create a public method void removeLine(int index) that removes a line from the array list at location index.
    // Make sure to subtract 1 from the parameter variable index before removing the line from arrayList lines.
    // Make sure that index-1 is in the range 0 to lines.size()-1
    // If it is not in this range, do nothing.
    //-----------Start below here. To do: approximate lines of code = 3
    //
    public void removeLine(int index) {
        try {
            lines.remove(index-1);
            addedLines--;
        }
        catch (Exception e) {}
    }
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.


}
