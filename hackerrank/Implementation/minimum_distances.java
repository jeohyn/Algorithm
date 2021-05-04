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
     * Complete the 'minimumDistances' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int minimumDistances(List<Integer> a) {
    // Write your code here
        int min=1002;
        while(a.size()>1){
            Integer target=a.remove(0);
            int index=a.indexOf(target);
            if(index!=-1){
                a.remove(index);
                if(min>index+1) min=index+1;
            }
        }
        if(min==1002) return -1;
        return min;
    }

}