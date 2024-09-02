/**
 * This program allows for testing a Priority Queue that stores Task objects.
 * You are to complete the following:
 *
 * - Create a PriorityQueue that orders Tasks using the Comparable functionality
 * - Add tasks to that priority queue
 * - Implement a Comparator that orders tasks first by time and then by priority
 * - Create a PriorityQueue that orders Tasks using your Comparator
 * - Add tasks to that priority queue
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class ToDoList
{
    public static void main(String[] args)
    {
        Task task1 = new Task("clean bedroom", 5, 25);
        Task task2 = new Task("fix hole in roof", 1, 180);
        Task task3 = new Task("fix leaky faucet", 2, 60);
        Task task4 = new Task("clean living room", 5, 20);
        Task task5 = new Task("take dog for walk", 4, 25);

        System.out.println("--- Test 1: Order by Comparable");

        //$start Create a Priority Queue called q, and add the 5 tasks above in the order given (ie. task1, followed by task2, etc.)
        PriorityQueue<Task> q = new PriorityQueue<>();
        q.add(task1);
        q.add(task2);
        q.add(task3);
        q.add(task4);
        q.add(task5);
        //$end

        runPriorityTest(q, "fix hole in roof\nfix leaky faucet\ntake dog for walk\nclean living room\nclean bedroom\n");
        //$start
        // Create a comparator that orders Tasks in terms of lowest estimated
        // minutes, and breaks ties using priority
        class TimeComparator implements Comparator<Task>
        {
            public int compare(Task o1, Task o2)
            {
                if (o1.getEstimatedMinutes() != o2.getEstimatedMinutes())
                {
                    return o1.getEstimatedMinutes() - o2.getEstimatedMinutes();
                }
                return o1.getPriority() - o2.getPriority();
            }
        }
        //$end

        System.out.println("\n---- Test 2: Order by your comparator ------");
        //$start Create a PriorityQueue called q2 of the Task objects above in the order given (ie. task1, followed by task2, etc.)
        // This time, pass an object of your comparator class to the constructor
        // so it orders elements using that criteria
        // Then add the tasks to the queue
        PriorityQueue<Task> q2 = new PriorityQueue<>(new TimeComparator());
        q2.add(task1);
        q2.add(task2);
        q2.add(task3);
        q2.add(task4);
        q2.add(task5);
        //$end

        runPriorityTest(q2, "clean living room\ntake dog for walk\nclean bedroom\nfix leaky faucet\nfix hole in roof\n");
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

    public static void runPriorityTest(PriorityQueue<Task> queue, String expected) {
        String output = "";
        while(!queue.isEmpty()) {
            output += queue.remove() + "\n";
        }

        printTestResult(testStringOutput("queue in order", "\n" + output, "\n" + expected));
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
