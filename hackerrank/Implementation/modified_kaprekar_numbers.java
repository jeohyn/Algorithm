import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
    // Write your code here
        int flag=0;
        for(int i=p; i<=q;i++){
            if(i==isItRight(i)){
                System.out.print(i+" ");
                flag++;
            }
        }
        if(flag==0) System.out.print("INVALID RANGE");
    }
    
    public static long isItRight(int i){
        long s=(long)Math.pow(i, 2);
        long t=s;   
        int d=0;
        while(t>0){
            if(t>=1) d++;
            t/=10;
        }
        //System.out.println("d:"+d);
        long r=0;
        if(d%2==0){
            for(int a=0;a<=Math.ceil(d/2)-1;a++){
                r=(long)(r+(s%10)*Math.pow(10, a));
                s/=10;
            }
        }
        else{
            for(int a=0;a<=Math.ceil(d/2);a++){
                r=(long)(r+(s%10)*Math.pow(10, a));
                s/=10;
            }
        }
        
        //System.out.println("r:"+r);
        long l=s;
        //System.out.println("l:"+l);
        return l+r;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
