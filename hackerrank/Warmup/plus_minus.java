import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int total=arr.length;
        int plus=0;
        int minus=0;
        int zero=0;
        for(int i=0; i<total; i++){
            if(arr[i]>0) plus++;
            else if(arr[i]==0) zero++;
            else minus++;
        }
        DecimalFormat df = new DecimalFormat("0.######");
        String plusN = df.format((float)plus/total);
        String minusN = df.format((float)minus/total);
        String zeroN = df.format((float)zero/total);
        System.out.println(plusN);
        System.out.println(minusN);
        System.out.println(zeroN);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
