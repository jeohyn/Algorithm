import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        ArrayList<Integer> i=new ArrayList<Integer>();
        ArrayList<Integer> res=new ArrayList<Integer>();
        
        for(int j=0; j<arr.length;j++){
            i.add(arr[j]);
        }
        
        Collections.sort(i);

        while(i.size()>0){
            res.add(i.size());
            deleteElement(i, i.get(0));    
        }
        
        int[] r = res.stream().mapToInt(Integer::intValue).toArray();
        return r;
        
    }
    

    private static void deleteElement(ArrayList<Integer> a, int b){
        while(a.indexOf(b)!=-1){
            a.remove((Integer)b);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
