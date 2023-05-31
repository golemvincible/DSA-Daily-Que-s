package O2BinaryTrees.day8;
import java.util.*;
class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}
public class LowestCommonAncestor {
    private static Node util(Node root, Node p, Node q){
        if(root==null || root==p || root==q)
            return root;

        //tracing the path from root to p or q

        /*
            * we will go both sides i.e. left as well as right
            * continue till we find p or q
            * if we found p on left then we will search for q on right
            * because if q is also on the left and we got p already that means
              p is our lca (if both p and q are on the same side of the tree then whoever
              comes first is lca)
            * if p and q are on the oppsite side of tree then root is lca
        */

        Node left = util(root.left,p,q);
        Node right = util(root.right,p,q);
        if(left!=null && right!=null)
            return root;

        //only one or both are null
        else if(left!=null)
            return left;
        return right;
    }
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root==null)
            return null;
        return util(root,p,q);
    }

    public static void main(String[] args) {

        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        Node n = lowestCommonAncestor(root,root.left,root.right.right);
        System.out.println(n.val);

    }
}
