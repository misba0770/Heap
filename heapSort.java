
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class heapSort {

    
    public static void main(String[] args) {
      Scanner s=new Scanner(System.in);
      int n=s.nextInt();
      int arr[]=new int[n];
      for(int i=0;i<n;i++){
          arr[i]=s.nextInt();
      }
      heapSort(arr,n);
      for(int i=0;i<n;i++){
          System.out.print(arr[i]+" ");
      }
    }

    private static void heapSort(int[] arr, int n) {
       buildHeap(arr,n);
       for(int i=n-1;i>0;i--){
           swap(arr,i,0);
           heapify(arr,i,0);
           
       }
    }

    private static void buildHeap(int[] arr, int n) {
        for(int i=n/2-1;i>=0;i--){
            heapify(arr,n,i);
        }
    }
    public static void heapify(int[] arr,int n,int i){
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<n&&arr[left]>arr[largest])largest=left;
        if(right<n&&arr[right]>arr[largest])largest=right;
        if(largest!=i){
            swap(arr,largest,i);
            heapify(arr,n,largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
}
