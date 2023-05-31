package O2BinaryTrees.day8;


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
public class BTPaths {
    private static void util(Node root,String route,List<String> path){
        if(root==null)
            return;
        if(root.right==null && root.left==null){
            route=route+String.valueOf(root.val);
            path.add(route);
            return;
        }

        //root
        route = route + String.valueOf(root.val) + "->";


        util(root.left,route,path);


        util(root.right,route,path);

    }
    public static List<String> binaryTreePaths(Node root) {
        List<String> path = new ArrayList<>();

        util(root,"",path);

        return path;
    }
    public static void main(String[] args) {

        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println(binaryTreePaths(root));

    }
}
