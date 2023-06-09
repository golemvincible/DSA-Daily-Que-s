package O2BinaryTrees.day11;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreefromInorderandPostorderTraversal {
    private static Map<Integer,Integer> mark(int[] inorder){

        Map<Integer,Integer> m = new HashMap<>();

        for(int i=0;i<inorder.length;i++)
            m.put(inorder[i],i);

        return m;
    }
    private static Node buildingTree(int[] inorder, int[] postorder,Map<Integer,Integer> m,int inStart,int inEnd,int postStart){
        if(postStart<0 || inStart>inEnd)
            return null;

        Node root = new Node(postorder[postStart]);

        int inInd = m.get(postorder[postStart]);
        int numRight = inEnd-inInd;   // numbers on the right side

        root.right = buildingTree(inorder,postorder,m,inInd+1,inEnd,postStart-1);
        root.left = buildingTree(inorder,postorder,m,inStart,inInd-1,postStart-numRight-1);

        return root;
    }
    public static Node buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> m = mark(inorder);

        //inStart -> postorder.length-1
        //inEnd -> postorder[0]
        //postStart -> postorder.length-1

        return buildingTree(inorder,postorder,m,0,postorder.length-1,postorder.length-1);
    }
    public static void main(String[] args) {
        int[] postorder={4,5,2,6,8,3,1};
        int[] inorder={4,2,5,1,6,3,8};
        Node root = buildTree(inorder,postorder);
    }
}
