package O2BinaryTrees.day5;
import java.util.*;
class Node {
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val=val;
    }
}

class Tuple{
    Node node;
    int x;
    int y;

    Tuple(Node node,int x,int y){
        this.node=node;
        this.x=x;
        this.y=y;
    }
}
public class VerticalOrderTraversal {
    public static List<List<Integer>> verticalTraversal(Node root) {
        Queue<Tuple> q = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

        //to map nodes with coordinates we will use map
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> m = new TreeMap<>();
        /*
            * for every coordinate we make min heap
            * because there might exist more than one node for a coordinate
              so we need to arrange them in ascending order
        */
        q.offer(new Tuple(root,0,0));

        while(!q.isEmpty()){
            Tuple t = q.poll();

            Node node = t.node;
            int x = t.x;
            int y = t.y;

            if(!m.containsKey(y)){
                m.put(y,new TreeMap<>());
            }

            if(!m.get(y).containsKey(x)){
                m.get(y).put(x,new PriorityQueue<>());
            }

            m.get(y).get(x).offer(node.val);

            if(node.left!=null)
                q.offer(new Tuple(node.left,x+1,y-1));
            if(node.right!=null)
                q.offer(new Tuple(node.right,x+1,y+1));

        }

        for(TreeMap<Integer,PriorityQueue<Integer>> it:m.values()){
            List<Integer> op=new ArrayList<>();

            for(PriorityQueue<Integer> pq : it.values()){
                while(!pq.isEmpty()){
                    op.add(pq.poll());
                }
            }

            res.add(op);
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.left.right = new Node(2);
        root.left.right.left = new Node(3);

        System.out.println(verticalTraversal(root));
    }
}
