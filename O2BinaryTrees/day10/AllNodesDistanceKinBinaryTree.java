package O2BinaryTrees.day10;
import java.util.*;

class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}
public class AllNodesDistanceKinBinaryTree {

    /*
     * Mark each node to its parent to traverse upwards
     * We will do a BFS traversal starting from the target node
     * As long as we have not seen our node previously, Traverse up, left, right until reached Kth distance
     * When reached Kth distance, break out of BFS loop and remaining node's values in our queue is our result
     */

    //marking the parents
    private static void markingParents(HashMap<Node,Node> parent, Node root){
        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                Node node = q.poll();

                if(node.left!=null){
                    parent.put(node.left,node);
                    q.offer(node.left);
                }

                if(node.right!=null){
                    parent.put(node.right,node);
                    q.offer(node.right);
                }

            }
        }
    }


    private static List<Integer> bfs(Node root, Node target, int k,HashMap<Node,Node> parent){
        int dis=0;

        //it will keep track of all visited nodes
        HashSet<Node> vis = new HashSet<>();

        Queue<Node> q = new LinkedList<>();

        q.offer(target);
        vis.add(target);

        List<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){

                //remaining nodes are my answer so we will add them as it is
                if(dis==k){
                    res.add(q.poll().val);
                    continue;
                }

                Node node = q.poll();

                //3 conditions must be satisfied

                //left child 
                if(node.left!=null && !vis.contains(node.left)){
                    q.offer(node.left);
                    vis.add(node.left);
                }

                //right child
                if(node.right!=null && !vis.contains(node.right)){
                    q.offer(node.right);
                    vis.add(node.right);
                }

                //parent
                if(parent.containsKey(node) && !vis.contains(parent.get(node))){
                    q.offer(parent.get(node));
                    vis.add(parent.get(node));
                }


            }
            dis++;
        }
        return res;
    }
    public static List<Integer> distanceK(Node root, Node target, int k) {
        HashMap<Node,Node> parent = new HashMap<>();

        //marked the parents
        markingParents(parent,root);

        //we will now a bfs traversal till we reach k distance
        return bfs(root,target,k,parent);

    }
    public static void main(String[] args) {

        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        
        System.out.println(distanceK(root,root.left,1));

    }
}
