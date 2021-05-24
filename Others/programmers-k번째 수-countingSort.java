//programmers K번째 수 problem
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length;i++){
            int s=commands[i][0]-1;
            int e=commands[i][1];
            int r=commands[i][2]-1;
            int[] res=new int[e-s];
            
            for(int j=s; j<e; j++){
                res[j-s]=array[j];
            }
            
            res=counting(res);
            answer[i]=res[r];
        }
        return answer;
    }
    
    public static int[] counting(int[] res){
        int [] com=new int[101];
        int [] result=new int[res.length];
        for(int i=0;i<res.length;i++){
            com[res[i]]++;
        }
        for(int i=1; i<com.length;i++){
            com[i]+=com[i-1];
        }
        
        for(int i=res.length-1; i>=0;i--){
            int a=res[i];
            com[a]--;
            result[com[a]]=a;
        }
        return result;
    }
    

}
