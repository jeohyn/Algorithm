import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
         String hour="";
         String[] time=s.split(":");
         String am_pm=time[2].substring(2);
         time[2]=time[2].substring(0,2);
         String min=time[1];
         String sec=time[2];
         if(am_pm.equals("AM")){
             if(time[0].equals("12")) hour="00";
             else hour=time[0];
         }
         else{
             if(time[0].equals("12")) hour="12";
             else hour=Integer.toString(Integer.parseInt(time[0])+12);
         }
         return hour+":"+min+":"+sec;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}