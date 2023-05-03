package O2BinaryTrees.day2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}
public class LevelOrderTraversal {
    public static void printLevelOrder(Node root,List<List<Integer>> levelorder){
        if(root==null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        List<Integer> currLevel = new ArrayList<>();
        while(!q.isEmpty()){
            Node node=q.poll();
            if(node!=null){
                currLevel.add(node.val);
                if(node.left!=null)
                    q.offer(node.left);
                if(node.right!=null)
                    q.offer(node.right);
            }
            // node==null so we check whether queue is empty or not
            else if(!q.isEmpty()){
                levelorder.add(currLevel);
                q.offer(null);
                currLevel=new ArrayList<>();
            }else{
                levelorder.add(currLevel);
            }
        }
    }
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levelorder = new ArrayList<>();
        printLevelOrder(root,levelorder);
        return levelorder;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(levelOrder(root));

    }
}
