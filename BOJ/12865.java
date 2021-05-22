import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int w=scan.nextInt();
        int [] value=new int[n];
        int [] weight=new int[n];
        for(int i=0;i<n;i++){
            weight[i]=scan.nextInt();
            value[i]=scan.nextInt();
        }
        
        int [][] dp=new int[n+1][w+1];
        
        
        for(int i=1; i<n+1;i++){//물품
            for(int j=1;j<w+1;j++){//무게
                if(weight[i-1]<=j){
                    dp[i][j]=Math.max((value[i-1]+dp[i-1][j-weight[i-1]]), dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][w]);
    }
}
