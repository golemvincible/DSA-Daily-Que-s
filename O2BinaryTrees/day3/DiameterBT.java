package O2BinaryTrees.day3;

public class DiameterBT {
    private static int height(Node root){
        return root==null?0:(Math.max(height(root.left),height(root.right))+1);
    }
    public static int diameterOfBinaryTree(Node root) {
        if(root==null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);

        int ans = lh+rh;

        return Math.max(ans,Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)));
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(diameterOfBinaryTree(root));
    }
}
