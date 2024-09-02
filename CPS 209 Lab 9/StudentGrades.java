/**
 * For this problem, you will complete code for reading in Student information
 * from a file, store it in a map, prints the contents of the map, and allows
 * for updating values in the map. You are to complete the following tasks
 *
 * - Read students from a file into a map
 * - Implement printAllInfo which prints each student in the map
 * - Update the grades of certain students as described
 */

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class StudentGrades
{
    /**
     * Extracts a Map of students from the given filenam
     * @param filename The filename to read from
     * @return A Map of Students indexed by name
     */
    public static Map<String, Student> getStudents(String filename)
    {
        //$start Create a map called students with key of type String (student id) and value of type Student
        // Use a TreeMap to ensure that it is iterated in alphabetic order of the keys
        Map<String, Student> students = new TreeMap<String, Student>();
        //$end

        try {
            File studentData = new File(filename);
            Scanner in = new Scanner(studentData);

            while (in.hasNextLine()) {
                String line = in.nextLine();
                //$start Create a scanner to process each line
                // You can assume the file is well formatted as follows
                // The first String is the name, the second is the student ID
                // Then there are groups of two items. The first is course name and the second is course grade
                // See the Student Class for details on creating a student and adding a course and grade to it
                // Remember to add each student found to the map, where the ID is the key
                Scanner inputLine = new Scanner(line);
                String name = inputLine.next();
                String id = inputLine.next();
                Student student = new Student(name, id);
                while (inputLine.hasNext()) {
                    String course = inputLine.next();
                    String grade = inputLine.next();
                    student.addCourseAndGrade(course, grade);
                }

                students.put(student.getId(), student);
                //$end
            }

        } catch (IOException exception) {
            System.out.println("Error processing file: " + exception);
            System.exit(0);
        }
        return students;
    }

    /**
     * Gets a String with the info for each student in the map, one on a new line.
     *
     * @param students The student map to print
     * @return The info for all students in the map
     */
    public static String getAllInfoString(Map<String, Student> students)
    {

        //$start Print all the info for all students in the map
        // HINT: Use the toString method of a Student
        // HINT: Use .trim() to get rid of last space
        String s = "";
        Set<String> studentKeys = students.keySet();
        for (String key : studentKeys) {
            s += students.get(key).toString() + "\n";
        }
        return s.trim();
        //$end
    }
    public static void main(String[] args)
    {
        Map<String, Student> students = getStudents("students.txt");

        System.out.println("------ Test 1: Print out inputted students ------");
        runPrintAllInfoTest(students, "Joe DD1234 CPS209 B- CPS109 A-\nAdam HH2123 CPS209 B CPS109 D+\nJames JJ2345 CPS209 B+ CPS109 C+\nMiriam MM3456 CPS209 A+ CPS109 A+");

        //$start Update the course grade of a student with given id
        //ID: "DD1234" CPS209 update grade to B+
        //ID: "JJ2345" CPS209 update grade to A-
        //ID: "HH2123" CPS209 update grade to B+
        Student s = students.get("DD1234");
        s.updateGrade("CPS209", "B+");
        s = students.get("JJ2345");
        s.updateGrade("CPS209", "A-");
        s = students.get("HH2123");
        s.updateGrade("CPS209", "B+");
        //$end

        System.out.println("\n------ Test 2: Print out after updates ------");
        runPrintAllInfoTest(students, "Joe DD1234 CPS209 B+ CPS109 A-\nAdam HH2123 CPS209 B+ CPS109 D+\nJames JJ2345 CPS209 A- CPS109 C+\nMiriam MM3456 CPS209 A+ CPS109 A+");

        System.out.println("\n------ Test 3: Try Another Input File ------");
        students = getStudents("students2.txt");
        runPrintAllInfoTest(students, "Joe DL1234 CPS305 C- CPS109 A-\nAdam HH2125 CPS310 C- CPS209 B+\nJames JJ2345 CPS209 B+ CPS109 C+");
    }

    public static void runPrintAllInfoTest(Map<String, Student> students, String expected) {
        printTestResult(testStringOutput("getAllInfoString", "\n" + getAllInfoString(students), "\n" + expected));
    }

    public static void printTestResult(boolean pass)
    {
        if (pass) {
            System.out.println("*** TEST PASSES ***\n");
        } else {
            System.out.println("*******************************************");
            System.out.println("*************** TEST FAILED ***************");
            System.out.println("*******************************************\n");
        }
    }

    public static boolean testStringOutput(String methodName, String output, String expected)
    {
        System.out.println("OUTPUT of " + methodName + ":   " + output);

        if (output == null && expected == null) {
            return true;
        } else if (output == null || !output.equals(expected)) {
            System.out.println("EXPECTED of " + methodName + ": " + expected);
            System.out.println("    INCORRECT OUTPUT");
            return false;
        }
        return true;
    }
}
