import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

/* you only have to complete the function given below.  
Node is defined as  

class Node {
    int data;
    Node left;
    Node right;
}

*/
    public static void getOrder(Node root, ArrayList<Integer> res){
        Node b= null;
        res.add(root.data);
        if(root.left!=null){
            if(root.right!=null) b=root.right;
            getOrder(root.left, res);
        }
        if(root.left==null && root.right!=null) b=root.right;

        if(b!=null){
            getOrder(b, res);
        }
        
    }

    public static void inOrder(Node root) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        getOrder(root, res);
        Collections.sort(res);
        String result="";
        for(int i=0;i<res.size();i++){
            result+=res.get(i).toString()+" ";
        }
        System.out.println(result);
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        inOrder(root);
    }	
}