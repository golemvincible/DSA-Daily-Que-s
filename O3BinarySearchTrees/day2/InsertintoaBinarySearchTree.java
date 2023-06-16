package O3BinarySearchTrees.day2;
class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}
public class InsertintoaBinarySearchTree {
    //recursive
    /*
    * New node will be inserted at the place of null that means it won't be inserted replacing any node
    * It will be inserted where there is no node
    *               2
                  /   \
                      81
                    /    \
                 42       87
               /    \   /    \
                    66      90
                   /  \    /  \
                 45
    * We just need to find the right root till null and the right route means the right path
    * It will insert the new node at right null position
    */

    private static Node insert(Node root,int val){
        //we will only make new node when we reach null
        if(root==null){
            return new Node(val);
        }

        //searching for right position of new node
        if(val<root.val)
            root.left = insert(root.left,val);
        else
            root.right = insert(root.right,val);

        return root;
    }
    public Node insertIntoBST(Node root, int val) {
        return insert(root,val);
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

        Node newroot = insert(root,13);
    }
}
