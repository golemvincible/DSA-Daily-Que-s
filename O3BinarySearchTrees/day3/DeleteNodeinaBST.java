package O3BinarySearchTrees.day3;
class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}
public class DeleteNodeinaBST {
    private static Node findingMin(Node root){
        return root.left==null?root:findingMin(root.left);
    }
    public static Node deleteNode(Node root, int key) {
        if(root==null)  return null;

        //searching for the node
        if(key<root.val)
            root.left=deleteNode(root.left,key);
        else if(key>root.val)
            root.right=deleteNode(root.right,key);

            //if we are here that means we have found our node to delete
        else{
            /*if my node has only one child or child*/

            //if it has only left child or left subtree or no child
            if(root.right==null)
                return root.left;
                //if it has only right child or right subtree or no child
            else if(root.left==null)
                return root.right;
                //if we are here that means we have both left and right subtree or child
            /*
                * if my node has both left and right subtree
                * then in that case we will simply attach minimum element of 
                  right subtree.
            */
            else{
                Node toAttach = findingMin(root.right);
                
                /*
                    * attaching the left subtree of todelete node to toAttach node
                    * hume jo node delete krni hai uske left subtree ko preserve kr lenge that means
                      ese ke ese left subtree ko attach kr denge minimum wali node se
                    * then right ko return kr denge
                */

                toAttach.left=root.left;
                return root.right;
            }
        }
        return root;
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

        Node newroot = deleteNode(root,17);

    }
}
