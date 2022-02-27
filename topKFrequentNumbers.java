
import java.util.ArrayList;
import java.util.HashMap;
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
public class topKFrequentNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)arr[i]=s.nextInt();
        int k=s.nextInt();
        int[] ans=topkFreq(arr,n,k);
        for(int x:ans)System.out.print(x+" ");
    }

    private static int[] topkFreq(int[] arr, int n, int k) {
       
         
      HashMap<Integer,Integer> hm=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b) -> hm.get(a) - hm.get(b));
        for(int i=0;i<n;i++){
            if(!hm.containsKey(arr[i]))hm.put(arr[i],0);
            hm.put(arr[i],hm.get(arr[i])+1);
        }
        int ans[]=new int[k];
         for(int key : hm.keySet()){
            pq.add(key);
             if(pq.size()>k)pq.poll();
        }
        int c=k-1;
        while(!pq.isEmpty())ans[c--]=pq.poll();
        
        return ans;
    }
    
}
