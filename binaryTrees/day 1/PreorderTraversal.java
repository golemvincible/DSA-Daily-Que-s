import java.util.LinkedList;
import java.util.List;
class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}
public class PreorderTraversal {
    private static void preorderTrav(List<Integer> preorder, Node root){
        if(root==null)
            return;
        preorder.add(root.val);
        preorderTrav(preorder,root.left);
        preorderTrav(preorder,root.right);
    }
    public static List<Integer> preorderTraversal(Node root) {
        List<Integer> preorder = new LinkedList<>();
        preorderTrav(preorder,root);
        return preorder;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(preorderTraversal(root));
    }
}
