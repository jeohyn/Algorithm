import java.util.*;

public class Main{
    static int [][] map;
    static boolean [][] visit;
    static int[] dr={-1, 1, 0, 0};//세로
    static int[] dc={0, 0, -1, 1};//가로
    static Queue<Pair> enqueue=new LinkedList<Pair>();
    static ArrayList<Integer> arr=new ArrayList<Integer>();
    
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        
        map=new int[n][n];
        visit=new boolean[n][n];
        String s=null;
        for(int i=0; i<n;i++){
            s=scan.next();
            for(int j=0; j<n;j++){
                map[i][j]=s.charAt(j)-'0';
            }
        }

        
        for(int i=0; i<n;i++){
            for(int j=0; j<n;j++){
                if(map[i][j]==1 && !visit[i][j]){
                    bfs(i, j, n);
                }
            }
        }
        Collections.sort(arr);
        System.out.println(arr.size());
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
    }
    
    public static void bfs(int x, int y, int n){
        int count=1;
        visit[x][y]=true;
        int nx=0;
        int ny=0;
        enqueue.add(new Pair(x, y));
        while(!enqueue.isEmpty()){
            Pair p=enqueue.poll();
            for(int i=0; i<4; i++){
                nx=p.getX()+dc[i];
                ny=p.getY()+dr[i];
                if(nx>=0 && ny>=0 && nx<n && ny<n){
                    if(map[nx][ny]==1 && !visit[nx][ny]){
                         enqueue.add(new Pair(nx, ny));
                         count++;
                         visit[nx][ny]=true;
                     }
                 }
             }
         }
        arr.add(count);
    }
}

class Pair{
    private int x;
    private int y;
    public Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
