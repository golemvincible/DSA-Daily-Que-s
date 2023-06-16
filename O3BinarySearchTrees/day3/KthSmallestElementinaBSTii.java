package O3BinarySearchTrees.day3;
class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}
public class KthSmallestElementinaBSTii {
    static int ans=0,count=0;

    private static void dfs(Node root){
        if(root.left!=null)
            dfs(root.left);

        //means we found and seen minimum element
        count--;

        if(count==0){
            ans = root.val;
            return;
        }

        if(count>0 && root.right!=null)
            dfs(root.right);
    }

    private static int kthSmallest(Node root, int k) {

        count=k;
        dfs(root);

        return ans;
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
