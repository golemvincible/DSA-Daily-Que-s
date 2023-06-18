package O3BinarySearchTrees.day5;
class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}
public class PredecessorAndSuccessor {
    public static void findPreSuc(Node root, int key)
    {
    
        Node temp = root;
        Node pre = null;
        Node suc = null;

        //successor
        while(temp!=null){

            if(temp.val<=key){
                temp=temp.right;
            }
            else{
                suc = temp;
                temp=temp.left;
            }

        }

        System.out.println(suc.val);
        //predessesor
        while(root!=null){

            if(root.val<key){
                pre=root;
                root=root.right;
            }
            else{
                root=root.left;
            }

        }
        System.out.println(pre.val);

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

        findPreSuc(root,7);
    }
}
