package O3BinarySearchTrees.day1;
class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}
public class MinimumelementinBST {
    int minValue(Node root) {
        if(root==null)
            return -1;
        if(root.left==null)
            return root.val;
        return minValue(root.left);
    }
}
