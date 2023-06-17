package O3BinarySearchTrees.day4;

class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}
public class ValidateBinarySearchTree {
    private static boolean check(Node root,long minVal,long maxVal){
        if(root==null)
            return true;

        if(root.val<=minVal || root.val>=maxVal)
            return false;

        /*
         * all the elements on left of root must be smaller than root so for them maxVal = root.val
         * all the elements on right of root must be greater than root so for them minVal = root.val
         */
        return check(root.left,minVal,root.val) && check(root.right,root.val,maxVal);

    }
    public static boolean isValidBST(Node root) {
        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.left.right.right = new Node(8);
        root.right.left = new Node(12);
        root.right.right = new Node(17);
        root.right.right.left = new Node(16);
        System.out.println(isValidBST(root));
    }
}
