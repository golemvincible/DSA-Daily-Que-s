package O2BinaryTrees.day6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}
public class BoundaryTraversalBT {
    private static boolean isLeaf(Node node){
        return (node.left==null && node.right==null)?true:false;
    }
    private static void leftBoundary(Node root,ArrayList<Integer> res){
        Node curr = root.left;

        while(curr!=null){
            if(!isLeaf(curr))
                res.add(curr.val);
            if(curr.left!=null)
                curr=curr.left;
            else
                curr=curr.right;
        }
    }
    private static void onlyLeaf(Node root,ArrayList<Integer> res){
        if(root==null)
            return;

        if(root.left==null && root.right==null){
            res.add(root.val);
            return;
        }

        onlyLeaf(root.left,res);
        onlyLeaf(root.right,res);
    }
    private static void rightBoundary(Node root,ArrayList<Integer> res){
        Node curr = root.right;
        Stack<Integer> st = new Stack<>();

        while(curr!=null){
            if(!isLeaf(curr))
                st.push(curr.val);
            if(curr.right!=null)
                curr=curr.right;
            else
                curr=curr.left;
        }

        while(!st.isEmpty())
            res.add(st.pop());
    }
    public static ArrayList <Integer>  boundary(Node root)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Set<Node> nodes = new HashSet<>();
        if(!isLeaf(root))
            res.add(root.val);

        leftBoundary(root,res);
        onlyLeaf(root,res);
        rightBoundary(root,res);

        return res;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.left.right = new Node(2);
        root.left.right.left = new Node(3);

        System.out.println(boundary(root));
    }
}
