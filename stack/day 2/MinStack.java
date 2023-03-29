

import java.util.Stack;
class Pair{
    int ele,min;
    Pair(int ele,int min){
        this.ele=ele;
        this.min=min;
    }
}
public class MinStack {
    public MinStack() {

    }
    Stack<Pair> st = new Stack<>();
    int minVal=Integer.MAX_VALUE;
    public void push(int val) {

        minVal=Math.min(minVal,val);
        st.push(new Pair(val,minVal));
    }

    public void pop() {
        st.pop();
        if(st.isEmpty()){
            minVal=Integer.MAX_VALUE;
            return;
        }

        Pair p = st.peek();
        minVal = p.min;
    }

    public int top() {
        if(st.isEmpty())
            return 0;
        return st.peek().ele;
    }

    public int getMin() {
        if(st.isEmpty())
            return 0;
        return st.peek().min;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */