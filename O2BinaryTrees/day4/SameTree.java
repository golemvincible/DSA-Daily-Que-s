package O2BinaryTrees.day4;

public class SameTree {
    public static boolean isSameTree(Node p, Node q) {
        if(p==null && q==null)
            return true;
        else if(p==null || q==null)
            return false;
        if(p.val!=q.val)
            return false;
        /*
        * Agar dono true honge to true
        * agar 1 bhi condition false ho gyi to false return kr denge
        */
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.right.left = new Node(4);
        root1.right.right = new Node(5);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.right.left = new Node(4);

        if (isSameTree(root1, root2))
            System.out.println("Two Trees are identical");
        else System.out.println("Two trees are non-identical");
    }
}
