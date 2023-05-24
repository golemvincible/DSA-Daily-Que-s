package O2BinaryTrees.day7;

class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}
public class SymmetricTree {
    private static boolean isSame(Node root1,Node root2){
        if(root1==null && root2==null)
            return true;

        if(root1==null || root2==null)
            return false;

        if(root1.val!=root2.val)
            return false;

        return isSame(root1.left,root2.right) && isSame(root1.right,root2.left);
    }
    public static boolean isSymmetric(Node root) {
        return isSame(root.left,root.right);
    }

    public static void main(String[] args) {
        
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println(isSymmetric(root));
    }
}
