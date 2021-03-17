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
    public static String getOrder(Node root){
        String res="";
        Node b= null;
        if(root.left!=null){
            if(root.right!=null) b=root.right;
            res+=getOrder(root.left);
        }
        if(root.left==null && root.right!=null) b=root.right;

        if(b!=null){
            res+=getOrder(b);
        }
        res+=root.data;
        res+=" ";
        return res;
        
    }

    public static void postOrder(Node root) {
        String res=getOrder(root);
        System.out.println(res);
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
        postOrder(root);
    }
}