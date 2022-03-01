
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
public class reorganizeString {

    
    public static void main(String[] args) {
       Scanner s=new Scanner(System.in);
       String str=s.next();
       String ans=reorganize(str);
       if(ans.length()==0)ans="not possible";
       System.out.print(ans);
    }

    private static String reorganize(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);
            if(!map.containsKey(temp))map.put(temp,0);
            map.put(temp,map.get(temp)+1);
        }
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        pq.addAll(map.keySet());
        StringBuilder sb=new StringBuilder();
        while(pq.size()>1){
            char current=pq.poll();
            char next=pq.poll();
            sb.append(current);
            sb.append(next);
            map.put(current,map.get(current)-1);
            map.put(next,map.get(next)-1);
            if(map.get(current)>0)pq.add(current);
            if(map.get(next)>0)pq.add(next);
        }
        if(!pq.isEmpty()){
            char ch=pq.poll();
            if(map.get(ch)>1)return "";
            sb.append(ch);
        }
        return sb.toString();
    }
    
}
