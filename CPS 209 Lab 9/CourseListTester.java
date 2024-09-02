/**
 * For this question, you will store a set of course lists in a map. The map will
 * use course code as the key and store an array list of strings (ie. student names)
 * for each value. These correspond to the students in the class. You are to complete
 * the following:
 * <p>
 * - Complete the addStudentToCourse method which adds a student to the correct course list as long as they aren't in there already
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CourseListTester
{
    /**
     * Adds the student to the list of students in a course, where the lists are stored in a map
     * where the key is the course code.
     *
     * Should only add the student if they aren't already in the task list
     *
     * @param courseMap The course map
     * @param courseCode The course code
     * @param studentName The student name
     */
    public static void addStudentToCourse(Map<String, ArrayList<String>> courseMap, String courseCode, String studentName)
    {
        //$start
        // Check if courseCode is in the map using .containsKey
        // If it isn't, add a new ArrayList for the new course
        // If it is in the map, check if it is already in the associated array list. If not, add it to the array list
        if (courseMap.containsKey(courseCode)) {
            ArrayList<String> studentList = courseMap.get(courseCode);
            if (!studentList.contains(studentName)) {
                studentList.add(studentName);
            }
        } else {
            ArrayList<String> studentList = new ArrayList<>();
            studentList.add(studentName);
            courseMap.put(courseCode, studentList);
        }
        //$end
    }

    public static void main(String[] args)
    {
        Map<String, ArrayList<String>> courseMap = new HashMap<>();

        System.out.println("------ Test 1: Add one student ------");
        System.out.println("Adding student with course cps209, name Keanu Reeves");
        addStudentToCourse(courseMap, "cps209", "Keanu Reeves");
        printTestResult(testIntOutput("courseMap.size()", courseMap.size(), 1));
        checkCourseMapValue(courseMap, "cps209", "[Keanu Reeves]");


        System.out.println("------ Test 2: Add another student with new course------");
        System.out.println("Adding student with course cps305, name Charlize Theron");
        addStudentToCourse(courseMap, "cps305", "Charlize Theron");
        printTestResult(testIntOutput("courseMap.size()", courseMap.size(), 2));
        checkCourseMapValue(courseMap, "cps209", "[Keanu Reeves]");
        checkCourseMapValue(courseMap, "cps305", "[Charlize Theron]");

        System.out.println("------ Test 3: Add another student with previous course ------");
        System.out.println("Adding student with course cps209, name Charlize Theron");
        addStudentToCourse(courseMap, "cps209", "Charlize Theron");
        printTestResult(testIntOutput("courseMap.size()", courseMap.size(), 2));
        checkCourseMapValue(courseMap, "cps209", "[Keanu Reeves, Charlize Theron]");
        checkCourseMapValue(courseMap, "cps305", "[Charlize Theron]");

        System.out.println("------ Test 4: Add Several Other Students ------");
        System.out.println("Adding student with course cps209, name Idris Elba");
        addStudentToCourse(courseMap, "cps209", "Idris Elba");
        System.out.println("Adding student with course cps109, name Michael B. Jordan");
        addStudentToCourse(courseMap, "cps109", "Michael B. Jordan");
        System.out.println("Adding student with course cps109, name Michelle Yeoh");
        addStudentToCourse(courseMap, "cps109", "Michelle Yeoh");

        printTestResult(testIntOutput("courseMap.size()", courseMap.size(), 3));
        checkCourseMapValue(courseMap, "cps209", "[Keanu Reeves, Charlize Theron, Idris Elba]");
        checkCourseMapValue(courseMap, "cps305", "[Charlize Theron]");
        checkCourseMapValue(courseMap, "cps109", "[Michael B. Jordan, Michelle Yeoh]");

        System.out.println("\n------ Test 2: Add duplicate students and a new one ------");
        System.out.println("Adding student with course cps209, name Keanu Reeves");
        addStudentToCourse(courseMap, "cps209", "Keanu Reeves");
        System.out.println("Adding student with course cps109, name Michael B. Jordan");
        addStudentToCourse(courseMap, "cps109", "Michael B. Jordan");
        System.out.println("Adding student with course cps305, name Idris Elba");
        addStudentToCourse(courseMap, "cps305", "Idris Elba");

        printTestResult(testIntOutput("courseMap.size()", courseMap.size(), 3));
        checkCourseMapValue(courseMap, "cps209", "[Keanu Reeves, Charlize Theron, Idris Elba]");
        checkCourseMapValue(courseMap, "cps305", "[Charlize Theron, Idris Elba]");
        checkCourseMapValue(courseMap, "cps109", "[Michael B. Jordan, Michelle Yeoh]");
    }

    public static void checkCourseMapValue(Map<String, ArrayList<String>> courseMap, String courseCode, String expected)
    {
        String output = courseMap.get(courseCode).toString();
        printTestResult(testStringOutput("courseMap.get(" + courseCode + ")", output, expected));
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

    public static boolean testIntOutput(String methodName, int output, int expected)
    {
        System.out.println("OUTPUT of " + methodName + ":   " + output);
        if (output != expected) {
            System.out.println("EXPECTED of " + methodName + ": " + expected);
            System.out.println("    INCORRECT OUTPUT");
            return false;
        }
        return true;
    }
}
