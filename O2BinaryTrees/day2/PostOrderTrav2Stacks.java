package O2BinaryTrees.day2;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}
public class PostOrderTrav2Stacks {
    public static List<Integer> postorderTraversal(Node root) {
        List<Integer> res=new ArrayList<>();
        if(root==null)  return res;
        Node temp=root;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.push(temp);

        while(!st1.isEmpty()){
            Node node = st1.pop();
            st2.push(node);

            if(node.left!=null)
                st1.push(node.left);
            if(node.right!=null)
                st1.push(node.right);
        }

        while(!st2.isEmpty())
            res.add(st2.pop().val);

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
        System.out.println(postorderTraversal(root));
    }    
}
