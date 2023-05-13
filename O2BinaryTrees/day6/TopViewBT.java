import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
class Pair1{
    int y;
    Node node;
    Pair1(int y,Node node){
        this.y=y;
        this.node=node;
    }
}
public class TopViewBT {
    private static ArrayList<Integer> topView(Node root)
    {

        ArrayList<Integer> topview = new ArrayList<>();
        /*
            * we need to find the top view of bt so we know seeing tree from top
            * we will only see 1st node of every y coordinate
            * so we are making map m and adding the value of node for the corresponding y coordinate
            * only 1st time that's why we are checking !m.containsKey() then only we are
            * adding value for that position
        */
        TreeMap<Integer,Integer> m= new TreeMap<>();

        Queue<Pair1> q = new LinkedList<>();

        q.offer(new Pair1(0,root));

        while(!q.isEmpty()){
            int y = q.peek().y;
            Node node = q.peek().node;
            q.poll();

            if(!m.containsKey(y)){
                m.put(y,node.val);
            }

            if(node.left!=null)
                q.offer(new Pair1(y-1,node.left));
            if(node.right!=null)
                q.offer(new Pair1(y+1,node.right));

        }

        topview.addAll(m.values());

        return topview;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(topView(root));
    }
}
