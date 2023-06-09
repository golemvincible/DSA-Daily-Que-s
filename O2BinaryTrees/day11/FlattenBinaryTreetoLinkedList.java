package O2BinaryTrees.day11;

class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}

public class FlattenBinaryTreetoLinkedList {
    static Node prev = null;

    private static void flat(Node root){
        if(root==null){
            return;
        }

        flat(root.right);
        flat(root.left);

        root.right = prev;
        root.left=null;

        prev=root;
    }

    public static void flatten(Node root) {
        flat(root);
    }
}
