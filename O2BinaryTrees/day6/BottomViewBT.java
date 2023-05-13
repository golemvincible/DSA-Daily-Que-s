import java.util.*;
class Pair2{
    int y;
    Node node;
    Pair2(int y,Node node){
        this.y=y;
        this.node=node;
    }
}
public class BottomViewBT {
    public static ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        TreeMap<Integer,Integer> m= new TreeMap<>();
        Queue<Pair2> q = new LinkedList<>();

        q.offer(new Pair2(0,root));

        while(!q.isEmpty()){
            Pair2 p = q.poll();

            int y = p.y;
            Node n = p.node;

            //opposite of top view we need last values for every y coordinate
            m.put(y,n.val);

            if(n.left!=null)
                q.offer(new Pair2(y-1,n.left));
            if(n.right!=null)
                q.offer(new Pair2(y+1,n.right));

        }

        return new ArrayList<Integer>(m.values());
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(bottomView(root));
    }
}
