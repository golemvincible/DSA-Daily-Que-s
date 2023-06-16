package O3BinarySearchTrees.day3;

class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}

public class KthSmallestElementinaBST {
    private static int countNodes(Node root){
        if(root==null)  return 0;

        return countNodes(root.left) + countNodes(root.right) +1;
    }
    public static int kthSmallest(Node root, int k) {

        // all these nodes are smaller than root
        int count = countNodes(root.left);

        /*
         * if the value of k is smaller than count
         * eg. we are looking for 3rd smallest and count is 7 that means 7 nodes are smaller than root node
         * so we know our ans will lie on left subtree
         * if our k is equal to count that means root node itself is our ans
         * eg. we are looking for 8th smallest and value of count is 7 that means 7 nodes are smaller than root node
         * and we are looking for 8th node that means our root node is our ans
         */

        //ans will lie in the left subtree
        if(k<=count){
            return kthSmallest(root.left,k);
        }

        //count means all the nodes of left subtree +1 because root node also included
        else if(k>count+1){
            /*
             * eg. we are looking for 9th smallest and value of count is 7
             * that means 7 nodes are smaller than root node
             * so if we pass the value of k as 9 itself it won't work
             * because now we aren't searching for 9th smallest in the right subtree
             * we are searching for 1st smallest in it that's why we did k-count-1

             * we can also imagine like this-:
             * we are searching for 9th smallest node
             * we know 7 smallest nodes from the root node are in left subtree
             * including root node 8 nodes
             * so basically we need 1st smallest node from right subtree
             * that's why we did k-count-1
             */
            return kthSmallest(root.right,k-count-1);
        }

        //we are here that means this is the node we were looking for
        return root.val;
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

        System.out.println(kthSmallest(root,3));

    }
}
