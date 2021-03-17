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

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/

	public static int height(Node root) {
      	// Write your code here.
        int res=0;
        int res_l=0;
        int res_r=0;
        Node b= null;
        if(root.left!=null){
            if(root.right!=null){
                res_r=height(root.right)+1;
                res_l=height(root.left)+1;
                res=Math.max(res_r, res_l);
            }
            else{
                res=height(root.left)+1;
            }
        }
        else if(root.left==null && root.right!=null){
            res=height(root.right)+1;
        }

        return res;
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
        int height = height(root);
        System.out.println(height);
    }	
}