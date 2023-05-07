package O2BinaryTrees.day4;
import java.util.*;
public class ZigZagTraversalofBinaryTree {
    private static List<List<Integer>> zigzagTrav(Node root){
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        Queue<Node> q = new LinkedList<>();
        boolean flag=false; //       false->left to right   true->right to left
        q.offer(root);

        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                Node node = q.remove();
                if(node.left!=null)
                    q.offer(node.left);
                if(node.right!=null)
                    q.offer(node.right);
                level.add(node.val);
            }
            if(!flag){
                flag=true;
                res.add(new ArrayList(level));
            }else{
                flag=false;
                Collections.reverse(level);
                res.add(new ArrayList(level));
            }
        }
        return res;
    }
    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        return zigzagTrav(root);
    }

    public static void main(String[] args) {
        int i, j;
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println("Zig Zag Traversal of Binary Tree ");
        System.out.println(zigzagLevelOrder(root));
    }
}
