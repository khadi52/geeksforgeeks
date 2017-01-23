package crypt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sortingAlgorithms.InsertionSort;

/**
 * Created by CKhadija on 1/22/2017.
 */
public class ActivitySelection
{
    public static void main(String[] args) throws IOException
    {
        //get the no of tasks
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter no of tasks");
        int n = scanner.nextInt();
        //get the array of start and finish times of the tasks
        System.out.println("Enter tasks");
        int[] start = new int[n];
        int[] finish = new int[n];
        for(int i = 0; i < n; i++)
        {
            start[i] = scanner.nextInt();
            finish[i] = scanner.nextInt();
        }
        //now sort these tasks according to their finish times
        System.out.println("Tasks are ; ");
        displayTasks(start, finish);
        
        sortTasks(start, finish);
        
        ArrayList<Integer> tasks = doActivitySelection(start, finish);
        System.out.println("The tasks selected are : ");
        tasks.forEach(i -> System.out.println(i));
        
    }
    
    private static void displayTasks(int[] start, int[] finish)
    {
        int i, n = start.length;
        
        for(i = 0; i < n; i++)
        {
            System.out.print(start[i] + " ");
        }
        System.out.println();
        for(i = 0; i < n; i++)
        {
            System.out.print(finish[i] + " ");
        }
        System.out.println();
    }
    
    private static ArrayList<Integer> doActivitySelection(int[] start, int[] finish)
    {
        int n = start.length;
        ArrayList<Integer> tasks = new ArrayList<>();
        int prev_fin_time = 0;
        int current_index = 0;
        while(current_index < n)
        {
            if(prev_fin_time <= start[current_index])
            {
                tasks.add(current_index);
                prev_fin_time = finish[current_index];
            }
            current_index++;
        }
        return tasks;
    }
    
    private static void sortTasks(int[] start, int[] finish)
    {
        //using insertion sort here to sort based on finish times
        int n = start.length;
        int i = 0, j;
        while(i < n)
        {
            int finish_key = finish[i];
            int start_key = start[i];
            j = i - 1;
            while(j >= 0 && finish[j] > finish_key)
            {
                start[j + 1] = start[j];
                finish[j + 1] = finish[j];
                j--;
            }
            start[j + 1] = start_key;
            finish[j + 1] = finish_key;
            i++;
        }
        System.out.println("Tasks sorted in finishing order are : ");
        displayTasks(start, finish);
    }
    /*
    1 2
    3 4
    0 6
    5 7
    8 9
    5 9
     */
}
