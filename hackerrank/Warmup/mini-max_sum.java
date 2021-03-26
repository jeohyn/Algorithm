import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr, long sum) {
        Arrays.sort(arr);
        long max=sum-arr[0];
        long min=sum-arr[4];
        System.out.println(min+" "+max);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];
        long sum=0;

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int min=Integer.parseInt(arrItems[0]);
        int max=Integer.parseInt(arrItems[0]);
        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
            sum+=arrItem;
            if(arrItem<=min) min=arrItem;
            if(arrItem>=max) max=arrItem;
        }
        
        miniMaxSum(arr, sum);

        scanner.close();
    }
}
