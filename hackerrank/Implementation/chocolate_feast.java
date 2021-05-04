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
     * Complete the 'chocolateFeast' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c
     *  3. INTEGER m
     */

    public static int chocolateFeast(int n, int c, int m) {
    // Write your code here
        int bar=n/c;
        int w=bar;
        while(w>=m){
            int extra=w/m;
            bar+=extra;
            w-=extra*(m-1);
        }
        return bar;
    }

}
