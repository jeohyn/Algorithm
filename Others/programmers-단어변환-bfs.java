import java.util.*;
class Node{
    String data;
    int count;
    public Node(String data, int count){
        this.data=data;
        this.count=count;
    }
}
class Solution {
    public static int answer=51;
    public static Queue<Node> eq=new LinkedList<Node>();
    public int solution(String begin, String target, String[] words) {

        boolean[] visit=new boolean[words.length];

        
        int count=0;
        eq.add(new Node(begin, 0));
    
        
        while(!eq.isEmpty()){
            Node s=eq.poll();
            if(s.data.equals(target)){
                answer=Math.min(answer, s.count);
                break;
            }
            for(int i=0; i<words.length;i++){
                if(!visit[i] && compare(s.data, words[i])){
                    visit[i]=true;
                    eq.add(new Node(words[i], s.count+1));
                }

            }
        }

        if(answer==51) return 0;
        return answer;
    }
    

    
    public static boolean compare(String a, String b){
        int count=0;

        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i))
                count++;
            if(count>1) return false;
        }
        if(count==1) return true;
        return false;
    }
}
