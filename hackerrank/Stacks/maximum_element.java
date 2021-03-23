import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */
     

    
    public static List<Integer> getMax(List<String> operations) {
        Stack<Integer> main=new Stack<Integer>();
        Stack<Integer> track=new Stack<Integer>();
        
        ArrayList<Integer> res=new ArrayList<Integer>();
        
        for(int i=0; i<operations.size();i++){
            String arr=operations.get(i);
            if(arr.length()!=1){
                int a=Integer.parseInt(arr.substring(2));
                main.push(a);
                if (main.size()==1) {  
                    track.push(a);   
                }
                
                if (a>track.peek())  
                        track.push(a);  
                else
                    track.push(track.peek());
                
            }
            else if(arr.equals("2")){
                main.pop();
                track.pop();
            }
            else if(arr.equals("3")){
                res.add(track.peek());
            }
        }
        return res;   
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String opsItem = bufferedReader.readLine();
            ops.add(opsItem);
        }

        List<Integer> res = Result.getMax(ops);

        for (int i = 0; i < res.size(); i++) {
            bufferedWriter.write(String.valueOf(res.get(i)));

            if (i != res.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
