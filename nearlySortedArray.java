
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author misba zaidi
 */
public class nearlySortedArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)arr[i]=s.nextInt();
        int k=s.nextInt();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
         for(int i=0;i<n;i++){
            pq.add(arr[i]);
            if(pq.size()>k)System.out.print(pq.poll()+" ");
        }
        while(!pq.isEmpty())System.out.print(pq.poll()+" ");
    }
    
}
