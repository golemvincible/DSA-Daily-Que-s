package O3BinarySearchTrees.day2;
class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}
public class InsertintoaBinarySearchTreeIterative {
    private static Node insert(Node root,int val){
        if(root==null)  return new Node(val);
        //inserting only when we find null
        Node curr = root;
        //finding the right path (the right null)
        while(true){
            if(val<curr.val){
                if(curr.left==null){
                    curr.left = new Node(val);
                    break;
                }
                curr=curr.left;
            }
            else{
                if(curr.right==null){
                    curr.right= new Node(val);
                    break;
                }
                curr=curr.right;
            }
        }
        return root;
    }
    public static Node insertIntoBST(Node root, int val) {
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

        Node newroot = insertIntoBST(root,13);

    }
}
