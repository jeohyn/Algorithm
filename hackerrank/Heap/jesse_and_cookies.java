import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the cookies function below.
     */
    static int cookies(int k, int[] A) {
        /*
         * Write your code here.
         */
         int res=0;

         PriorityQueue<Integer> cookies=new PriorityQueue<Integer>();
         
         for(int i=0;i<A.length;i++){
             cookies.add(A[i]);
         }
         
         while(cookies.peek()<k && cookies.size()>1){
             int l=cookies.poll();
             int sl=cookies.poll();
             int newc=l+2*sl;
             cookies.add(newc);
             res++;
         }
         if(cookies.size()==1 && cookies.peek()<k) res=-1;
         return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
