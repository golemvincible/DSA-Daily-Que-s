
import java.util.*;
class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}
public class IterativePostorderTraversal {
    private static List<Integer> postorderTrav(Node root){
        LinkedList<Integer> res = new LinkedList<>();

        //so that we can push and pop from both ends
        Deque<Node> stack = new ArrayDeque<>();
        Node node = root;
        while (!stack.isEmpty() || node!=null){

            if(node!=null){
                stack.push(node);
                res.addFirst(node.val);
                node = node.right;
            }
            //picking element from stack and exploring its left
            else{
                Node n = stack.pop();
                node = n.left;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(postorderTrav(root));
    }
}