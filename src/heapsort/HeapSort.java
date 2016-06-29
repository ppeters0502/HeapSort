/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapsort;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


/**
 *
 * @author ppete_000
 */
public class HeapSort<AnyType extends Comparable<? super AnyType>>{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Now generate the number sequence.

        System.out.println("Please enter the heap elements. Separate each element"
                + " with a single space: ");
        try
        {
            boolean isDone = false;
            int choice, insert;
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            int[] a = new int[strs.length];
            for (int i = 0; i < strs.length; i++) 
            {
                a[i] = Integer.parseInt(strs[i]);
            }
            System.out.println("Provided Numbers: ");
            Comparable[] sequence = new Comparable[a.length];
            for (int i=0; i<a.length; i++)
            {
                System.out.println("Number "+(i+1)+": "+a[i]);
                sequence[i] = a[i];
            }
            System.out.println("Enter value d:");
            int d = sc.nextInt();
            BinaryHeap heapSort =  new BinaryHeap(sequence, d, sequence.length);
            System.out.print("Output: Heap (d="+d+"): ");
            heapSort.print();
            
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
                }
                else if (choice==3)
                {
                    System.out.println("Enter new d value: ");
                            d = sc.nextInt();
                            heapSort.buildHeap(d);
                            heapSort.print();
                }
               if (choice==4)
               {
                   System.out.println("Program Terminated");
               }
            
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }
    
   
    
}
