import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        PriorityQueue <Integer> arr=new PriorityQueue<Integer>();
        Scanner scan=new Scanner(System.in);
        int num=scan.nextInt();
        for(int i=0; i<num; i++){
            int q=scan.nextInt();
            switch(q){
                case 1:
                    int nums=scan.nextInt();
                    arr.add(nums);
                    break;
                case 2:
                    Object numss=scan.nextInt();
                    arr.remove(numss);
                    break;
                case 3:
                    System.out.println(arr.peek());
                    break;
                default:  
            }
        }
    }
    
}