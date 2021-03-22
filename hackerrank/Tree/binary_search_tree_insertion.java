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
  
  	public static void preOrder( Node root ) {
      
    	if( root == null)
        	return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

	public static Node insert(Node root,int data) {
    	Node start=root;
        Node target=new Node(data);
        while(start!=null){
            if(start.data<data){
                if(start.right==null) break;
                start=start.right;
            }
            else{
                if(start.left==null) break;
                start=start.left;
            }
        }
        
        if(root==null){
            root=target;
            return root;
        }
        
        else if(start.data<data){
            start.right=target;
        }
        else{
            start.left=target;
        }
        return root;
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
      	preOrder(root);
    }
}