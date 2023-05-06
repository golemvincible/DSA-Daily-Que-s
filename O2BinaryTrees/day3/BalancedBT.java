package O2BinaryTrees.day3;

public class BalancedBT {
    private static int height(Node root){
        return root==null?0:(Math.max(height(root.left),height(root.right))+1);
    }
    public static boolean isBalanced(Node root) {
        if(root==null)
            return true;

        int lh = height(root.left);
        int rh = height(root.right);

        if(Math.abs(lh-rh)>1)
            return false;
        if(!isBalanced(root.left))
            return false;
        if(!isBalanced(root.right))
            return false;

        return true;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(isBalanced(root));
    }
}
