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
        int N;
        int START = 1;
        int END = 50; 
        
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //This is for random numbers, be sure to remove this before submitting!
        Random random = new Random();
        System.out.println("Please enter the amount of elements: ");
        N = sc.nextInt();
        //Now generate the number sequence.
        int[] sequence = new int[N];
       for (int i = 0; i<N; i++)
       {
           sequence[i] = randomNumberGenerator(START, END, random); 
           if (N<=50)
           {
               System.out.print(sequence[i]+", ");
           }
       }
       
        BinaryHeap heapSort =  new BinaryHeap();
       
        heapSort.print();
        
        System.out.println("Is this sorted?");
        heapSort.print();
//        System.out.println("Please enter the heap elements. Separate each element"
//                + " with a single space: ");
//        try
//        {
//            String line = br.readLine();
//            String[] strs = line.trim().split("\\s+");
//            int[] a = new int[strs.length];
//            for (int i = 0; i < strs.length; i++) 
//            {
//                a[i] = Integer.parseInt(strs[i]);
//            }
//            System.out.println("Provided Numbers: ");
//            for (int i=0; i<a.length; i++)
//            {
//                System.out.println("Number "+(i+1)+": "+a[i]);
//            }
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }
        
    }
    
    private static int randomNumberGenerator(int aStart, int aEnd, Random aRandom)
    {
        long numberRange = (long)aEnd - (long)aStart + 1;
        long fraction = (long)(numberRange * aRandom.nextDouble());
        int randomNumber = (int)(fraction + aStart);
        return randomNumber;
        
    }
    
}
