public class Lcs_subsequence {
    public static void main(String[] args){
        char[] first={'a','b','c','d','e'};
        char[] second={'a','c','b','c','d'};
        lcs(first, second);
    }
    public static void lcs(char[] first, char[] second){
        int[][]dp=new int[first.length+1][second.length+1];
        //int max=0;
        for(int i=1; i<=first.length;i++){
            for(int j=1; j<=second.length;j++){
                if(first[i-1]==second[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                    //max=Math.max(max, dp[i][j]);
                }
            }
        }
        System.out.println(dp[first.length][second.length]);
    }
}
