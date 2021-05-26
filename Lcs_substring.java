public class Lcs_substring{
    public static void main(String[] args){
        char[] first={'a','b','c','d','e'};
        char[] second={'c','a','b','c','d'};
        lcs(first, second);
    }
    public static void lcs(char[] first, char[] second){
        int max=0;
        int end=0;
        
        int[][] dp=new int[first.length+1][second.length+1];
        for(int i=1;i<=first.length;i++){
            for(int j=1;j<=second.length;j++){
                if(first[i-1]==second[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    if(max<dp[i][j]){
                        max=dp[i][j];
                        end=i-1;
                    }
                }
            }
        }
        String ans="";
        for(int i=end-max+1; i<=end;i++){
            ans+=Character.toString(first[i]);
        }
        System.out.println(ans);
    }
    
}
