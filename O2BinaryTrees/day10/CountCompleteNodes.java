package O2BinaryTrees.day10;
class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}
public class CountCompleteNodes {
    private static int heightL(Node root){
        int height=0;
        while(root.left!=null){
            height++;
            root=root.left;
        }
        return height;
    }
    private static int heightR(Node root){
        int height=0;
        while(root.right!=null){
            height++;
            root=root.right;
        }
        return height;
    }
    private static int helper(Node root){
        if(root==null)  return 0;
        int lh = heightL(root);
        int rh = heightR(root);

        if(lh==rh)  return ((2<<(lh)) - 1);

        return helper(root.left) + helper(root.right) + 1;

    }
    public static int countNodes(Node root) {
        return helper(root);
    }
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println(countNodes(root));
    }
}
