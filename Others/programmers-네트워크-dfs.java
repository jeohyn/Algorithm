class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int len=computers.length;
        boolean[] visit=new boolean[len];
        for(int i=0; i<computers.length;i++){
            if(!visit[i]){
                answer++;
                dfs(i, visit, computers);
            }
        }
        return answer;
    }
    public void dfs(int current, boolean[] visit, int[][] computers){
        visit[current]=true;
        int ans=0;

        for(int i=0; i<computers.length;i++){
            if(!visit[i] && computers[current][i]==1){
                dfs(i, visit, computers);
            }
        }
    }
}
