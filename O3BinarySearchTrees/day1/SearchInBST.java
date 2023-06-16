package O3BinarySearchTrees.day1;

class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}
public class SearchInBST {
    private static boolean search(Node root,int val){
        if(root==null)
            return false;

        if(root.val==val)
            return true;

        if(val<root.val)
            return search(root.left,val);
        return search(root.right,val);
    }
    public boolean searchBST(Node root, int val) {
        return search(root,val);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        System.out.println(search(root,8));
    }
}
