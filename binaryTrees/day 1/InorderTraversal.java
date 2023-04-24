import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {
    private static void inorderTrav(Node root, List<Integer> inorder){
        if(root==null)
            return;
        inorderTrav(root.left,inorder);
        inorder.add(root.val);
        inorderTrav(root.right,inorder);
    }
    public static List<Integer> inorderTraversal(Node root) {
        List<Integer> inorder = new LinkedList<>();
        inorderTrav(root,inorder);
        return inorder;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(inorderTraversal(root));
    }

}

