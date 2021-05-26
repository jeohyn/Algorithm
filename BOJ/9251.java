import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
    public static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char[] firstString=br.readLine().toCharArray();
        char[] secondString=br.readLine().toCharArray();
        
        dp=new int[firstString.length+1][secondString.length+1];
       
         int answer=lcs(firstString, secondString);
        System.out.println(answer);
    }
    
    public static int lcs(char[] first, char[] second){
        for(int i=1; i<=first.length;i++){
            for(int j=1; j<=second.length;j++){
                if(first[i-1]==second[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[first.length][second.length];
    }
}
