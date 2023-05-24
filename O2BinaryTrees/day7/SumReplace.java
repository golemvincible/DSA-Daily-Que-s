package O2BinaryTrees.day7;

public class SumReplace {
    static int max=0;
    private static void sumReplace(Node root){
        if(root==null)
            return;
        sumReplace(root.left);
        sumReplace(root.right);

        if(root.left!=null)
            root.val+=root.left.val;
        if(root.right!=null)
            root.val+=root.right.val;

    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        sumReplace(root);
        
    }
}
