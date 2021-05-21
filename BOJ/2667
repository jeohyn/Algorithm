import java.util.*;

public class Main{
    static int[] dr={-1, 1, 0, 0};//세로. 상 하 좌 우
    static int[] dc={0, 0, -1, 1};//가로. 상 하 좌 우
    static int[][] map;
    static boolean[][] visit;
     public static void main(String[] args){
         int count=0;
         ArrayList<Integer> arr=new ArrayList<Integer>();
         Scanner scan=new Scanner(System.in);
         int n=scan.nextInt();
         visit=new boolean[n][n];
         
         map=new int[n][n];
         for(int i=0;i<n;i++){
             String input=scan.next();
             for(int j=0; j<n;j++){
                 map[i][j]=input.charAt(j)-'0';
             }
         }
         
         for(int i=0;i<n;i++){
             for(int j=0; j<n;j++){
		        if(map[i][j]==1 && !visit[i][j]){
			        count=1;
			        count=dfs(i, j, n, count);
			        arr.add(count);
                }
             }
         }

         Collections.sort(arr);
         System.out.println(arr.size());
         for(int c : arr){
             System.out.println(c);
         }
     }
    
    public static int dfs(int x, int y, int n, int count){
        visit[x][y]=true;
        for(int i=0; i<4; i++){
	        int nx=x+dc[i];
	        int ny=y+dr[i];
	        if(nx>=0 && ny>=0 && nx<n && ny<n){
		        if(map[nx][ny]==1 && !visit[nx][ny]){
			        count=dfs(nx, ny, n, count);
			        count++;
			    }
		    }
	    }    
	return count;
    } 
}
