/**
 * Encodes a string by replacing all letters "i" with "!" and
 * all letters "s" with "$". Use the replace method of class String. Look up the documentation of this method to see how to use it.
 * Do this with variable town (see code below), assigning the result to variable townEncoding,
 * and with the variable sentence, assigning the result to variable sentenceEncoding.
 *
 *
 */

public class StringReplace
{
    public static void main(String[] args)
    {
        String town = "Mississauga";
        String townEncoding;
        String sentence = "This is a simple sentence.";
        String sentenceEncoding;

        // For the following, use the String replace method. Look up the details of how to do that
        //-----------Start below here. To do: approximate lines of code = 4
        // 1. Assign to townEncoding the result of applying the replace method to town to replace "i" with "!" ;
        townEncoding =  town.replace('i', '!');
        //2. now update townEncoding by replacing s to $ in string townEncoding;
        townEncoding =  townEncoding.replace('s', '$');
        //3. assign to sentenceEncoding the result of applying replace() on sentence to replace "i" with "!".
        sentenceEncoding = sentence.replace('i', '!');
        //4. now replace s with $ in string sentenceEncoding (i.e. update sentenceEncoding).
        sentenceEncoding = sentenceEncoding.replace('s', '$');
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

        System.out.println("------ Town Test -------");

        System.out.println("OUTPUT   : The encoding is " + townEncoding);
        System.out.println("EXPECTED : The encoding is M!$$!$$auga");

        System.out.println("\n\n------ Sentence Test -------");
        System.out.println("OUTPUT   : The encoding is " + sentenceEncoding);
        System.out.println("EXPECTED : The encoding is Th!$ !$ a $!mple $entence.");
    }
}
