package O3BinarySearchTrees.day4;
class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}
public class LCA {
    private static Node lca(Node root,Node p,Node q){
        if(root==p || root==q)
            return root;

        if(p.val<root.val && q.val>root.val || p.val>root.val && q.val<root.val)
            return root;

        if(p.val<root.val && q.val<root.val)
            return lca(root.left,p,q);

        return lca(root.right,p,q);
    }
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        return lca(root,p,q);
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

        System.out.println(lowestCommonAncestor(root,root.left.left,root.left.right.right).val);
    }
}
