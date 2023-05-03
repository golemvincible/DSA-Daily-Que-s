import java.util.LinkedList;
import java.util.List;
public class PostorderTraversal {
    private static void postorderTrav(Node root, List<Integer> postorder){
        if(root==null)
            return;
        postorderTrav(root.left,postorder);
        postorderTrav(root.right,postorder);
        postorder.add(root.val);
    }
    public static List<Integer> postorderTraversal(Node root) {
        List<Integer> postorder = new LinkedList<>();
        postorderTrav(root,postorder);
        return postorder;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(postorderTraversal(root));
    }
}
