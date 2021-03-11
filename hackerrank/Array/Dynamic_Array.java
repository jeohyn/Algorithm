import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        int lastAnswer=0;
        ArrayList<Integer> res=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
        
        for(int i=0;i<n;i++){
            ArrayList<Integer> start=new ArrayList<Integer>();
            start.add(-1);
            arr.add(start);
        }

        for(int i=0; i<queries.size();i++){
            int q=queries.get(i).get(0);
            int x=queries.get(i).get(1);
            int y=queries.get(i).get(2);

            int index=(x^lastAnswer)%n;
            
            if(q==1){
                ArrayList<Integer> ar=new ArrayList<Integer>();
                ar=arr.get(index);
                if(ar.contains(-1)){
                    ar.set(0, y);
                }
                else{
                    ar.add(y);
                }
                arr.set(index, ar);
            }
            else{
                lastAnswer=arr.get(index).get(y%(arr.get(index).size()));
                res.add(lastAnswer);
            }
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<Integer> result = Result.dynamicArray(n, queries);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
