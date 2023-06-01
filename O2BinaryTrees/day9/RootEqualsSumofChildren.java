package O2BinaryTrees.day9;

class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}
public class RootEqualsSumofChildren {
    private static boolean check(Node root){
        if(root==null)
            return true;

        if(root.left!=null && root.right!=null){
            if((root.left.val+root.right.val)==root.val)
                return check(root.left) && check(root.right);
            else
                return false;
        }
        else if(root.left==null && root.right==null)
            return true;
        return false;

    }
    public static boolean checkTree(Node root) {
        return check(root);
    }
    public static void main(String[] args) {

        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println(checkTree(root));

    }
}
