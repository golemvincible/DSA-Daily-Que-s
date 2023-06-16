package O3BinarySearchTrees.day2;
class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}

public class FloorinBST {
    static int f = Integer.MIN_VALUE;

    private static void search(Node root,int key){
        if(root==null)
            return;

        if(key==root.val)
            f=key;
        else if(root.val<key){
            if(root.val>f)
                f=root.val;
        }
        /*
        * if the key is not root value then we will keep on searching for values
        * we know our ans will be b/w f and key
        * suppose x is our ans so f < x < key
        * so if we found a value of x that is between f and key we will store it in ceil
        * if sometime later we again found root value which is greater than key we will again compare it
          with old value of ceil and if it is smaller than we will again update the ceil value to our new value
        */
        if(key<root.val){
            search(root.left,key);
        }

        search(root.right,key);
    }
    public static int floor(Node root, int x) {
        search(root,x);

        return f==Integer.MIN_VALUE?-1:f;
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

        floor(root,13);

        System.out.println(f);
    }
}
