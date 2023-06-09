package O2BinaryTrees.day11;

import java.util.HashMap;
import java.util.Map;
class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}
public class BinaryTreefromPreorderandInorderTraversal {
    private static Map<Integer,Integer> mark(int[] inorder){

        Map<Integer,Integer> m = new HashMap<>();

        for(int i=0;i<inorder.length;i++)
            m.put(inorder[i],i);

        return m;
    }

    private static Node buildingTree(int[] preorder, int[] inorder,Map<Integer,Integer> m,int preStart,int inStart,int inEnd){
        if(preStart>preorder.length || inStart>inEnd){
            return null;
        }

        Node root = new Node(preorder[preStart]);

        //index of just made root in inorder
        int inInd = m.get(preorder[preStart]);

        //numbers on the left
        int numsLeft = inInd-inStart;

        root.left = buildingTree(preorder,inorder,m,preStart+1,inStart,inInd-1);
        root.right = buildingTree(preorder,inorder,m,preStart+numsLeft+1,inInd+1,inEnd);

        return root;
    }

    public static Node buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> m = mark(inorder);


        //contructing the tree from inorder and preorder

        //so we need to keep track of their indexes thats why we took inorderStart, inorderEnd,preorderStart
        return buildingTree(preorder,inorder,m,0,0,preorder.length-1);
    }

    public static void main(String[] args) {
        int[] preorder={1,2,4,5,3,6,7};
        int[] inorder={4,2,5,1,6,3,7};
        Node root = buildTree(preorder,inorder);
        
    }
}
