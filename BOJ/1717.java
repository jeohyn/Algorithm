import java.util.*;

public class Main{
     public static int[] root;
     public static void main(String[] args){
         Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
         int m=sc.nextInt();
         root=new int[n+1];
         for(int i=0; i<=n;i++){
             root[i]=i;
         }
         for(int i=0; i<m;i++){
             int c=sc.nextInt();
             int x=sc.nextInt();
             int y=sc.nextInt();
             if(c==0){//union
                 union(x, y);
             }
             else{//find
                 x=find(x);
                 y=find(y);
                 if(x==y){
                     System.out.println("YES");
                 }
                 else{
                     System.out.println("NO");
                 }
             }
         }
         sc.close();
     }
    
    public static void union(int x, int y){
        x=find(x);
        y=find(y);
        if(x!=y){
            root[y]=x;
        }
    }
    public static int find(int x){
        if(x==root[x]){
            return x;
        }
        else{
            return root[x]=find(root[x]);
        }
    }
}
