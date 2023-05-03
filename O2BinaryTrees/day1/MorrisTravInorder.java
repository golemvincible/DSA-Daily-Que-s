import java.util.ArrayList;
import java.util.List;
class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}
public class MorrisTravInorder {
    private static List<Integer> inorderTraversal(Node root){
        List<Integer> inorder = new ArrayList<>();

        Node curr = root;

        while(curr!=null){
            if(curr.left==null){
                inorder.add(curr.val);
                curr=curr.right;
            }
            else {
                Node prv = curr.left;
                while (prv.right!=null && prv.right!=curr){
                    prv=prv.right;
                }
                if (prv.right==null){
                    //made the link
                    prv.right=curr;

                    //moving forward
                    curr=curr.left;
                }
                //already linked to curr so we need to de link
                else {
                    prv.right=null;
                    inorder.add(curr.val);
                    curr=curr.right;
                }
            }
        }

        return inorder;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        System.out.println(inorderTraversal(root));
    }
}
