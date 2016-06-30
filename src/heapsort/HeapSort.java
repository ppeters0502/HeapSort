/***************************************************
 * Program Title: Programming assignment #2 - D-ary Heap Sort *
 * Author: Patrick Peters *
 * Class: CSCI3320, Fall 2016 *
 * Assignment #2 *
 * HeapSort *
 * Contains main method that prompts the user for input
 * and sends the required elements (array and d value)
 * to 
 ****************************************************/ 
package heapsort;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author ppete_000
 */
public class HeapSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Now generate the number sequence.

        System.out.println("Please enter the heap elements. Separate each element"
                + " with a single space: ");
        boolean isDone = false;
        try
        {
            
            int choice, insert;
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            int[] a = new int[strs.length];
            for (int i = 0; i < strs.length; i++) 
            {
                a[i] = Integer.parseInt(strs[i]);
            }
            int[] sequence = new int[a.length];
            for (int i=0; i<a.length; i++)
            {
                sequence[i] = a[i];
            }
            System.out.println("Enter value d:");
            int d = sc.nextInt();
            BinaryHeap heapSort =  new BinaryHeap(sequence, d, sequence.length);
            System.out.print("Output: Heap (d="+d+"): ");
            heapSort.print();
            
            while(isDone==false)
            {
                System.out.println("Press 1) for insert, 2) for deleteMin, 3) "
                        + "for new d value, 4) to quit");
                System.out.print("Enter Choice: ");
                choice = sc.nextInt();
                if (choice==1)
                {
                    System.out.println("Enter element to insert: ");
                    insert = sc.nextInt();
                    heapSort.insert(insert, d);
                    heapSort.print();
                    isDone = false;
    
                }
                else if (choice==2)
                {
                    heapSort.deleteMin();
                    System.out.print("Output: Heap (d="+d+"): ");
                    heapSort.print();
                    isDone = false;
                }
                else if (choice==3)
                {
                    System.out.println("Enter new d value: ");
                            d = sc.nextInt();
                           //BinaryHeap heapSort2 = new BinaryHeap(sequence, d, sequence.length);
                            System.out.println("New D:"+d);
                            heapSort.buildHeap(sequence, d);
                            System.out.print("Output: Heap (d="+d+"): ");
                            heapSort.print();
                            isDone = false;
                }
               if (choice==4)
               {
                   System.out.println("Program Terminated");
                   isDone = true;
               }
            }
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }
    
   
    
}
