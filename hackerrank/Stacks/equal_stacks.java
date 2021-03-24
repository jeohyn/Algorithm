import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3, int t1, int t2, int t3) {

        int flag1=0; int flag2=0; int flag3=0;
        int min=Math.min(Math.min(t1, t2), t3);
        
        while(t1 != t2 || t1 != t3){
            while(t1>min){
                t1-= h1.remove(0);
            }
            min=Math.min(t1,Math.min(t2,t3));
            while(t2>min){
                t2-=h2.remove(0);
            }
            min=Math.min(t2,Math.min(t1,t3));
            while(t3>min){
                t3-=h3.remove(0);
            }
            min=Math.min(t1,Math.min(t2,t3));
        }
        return min;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);
        
        int t1=0; int t2=0; int t3=0;
        
        String[] h1Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h1 = new ArrayList<>();
        
        for (int i = 0; i < n1; i++) {
            int h1Item = Integer.parseInt(h1Temp[i]);
            t1+=h1Item;
            h1.add(h1Item);
        }

        String[] h2Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h2 = new ArrayList<>();

        for (int i = 0; i < n2; i++) {
            int h2Item = Integer.parseInt(h2Temp[i]);
            t2+=h2Item;
            h2.add(h2Item);
        }

        String[] h3Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h3 = new ArrayList<>();

        for (int i = 0; i < n3; i++) {
            int h3Item = Integer.parseInt(h3Temp[i]);
            t3+=h3Item;
            h3.add(h3Item);
        }
        

        int result = Result.equalStacks(h1, h2, h3, t1, t2, t3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}