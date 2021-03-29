import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
        int res=0;
        ArrayList<Integer> as=new ArrayList<Integer>();
        int multiple=a.get(0);
        if(a.size()==2) multiple=commonMultiple(a.get(0), a.get(1));
        else if(a.size()>2){
            for(int i=1; i<a.size();i++) multiple=commonMultiple(multiple, a.get(i));
        }

        int k=multiple;
        while(multiple<=b.get(0)){
            as.add(multiple);
            multiple+=k;
        }
        
        int euclids=b.get(0);
        if(b.size()==2) euclids=euclid(b.get(0), b.get(1));
        else if(b.size()>2){
            for(int j=1; j<b.size(); j++) euclids=euclid(euclids, b.get(j));
        }
        
        for(int t=0; t<as.size(); t++){
            if(euclids%as.get(t)==0) res++;
        }
        return res;
    }
    
    public static int euclid(int a, int b){
        if(b==0) return a;
        return euclid(b, a%b);
    }
    
    public static int commonMultiple(int a, int b){
        return a*b/euclid(a, b);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        String[] brrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> brr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrTemp[i]);
            brr.add(brrItem);
        }

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}