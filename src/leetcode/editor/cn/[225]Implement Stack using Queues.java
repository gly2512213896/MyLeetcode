import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class MyStack {
    Deque<Integer> que;
    public MyStack() {
          que=new ArrayDeque<>();
    }

    //convert the sequence of `que1` to stack at time of putting x into it
    public void push(int x) {
       que.addLast(x);
       int size=que.size();
       size--;
       while(size-->0){
           que.addLast(que.pollFirst());
       }
    }
    
    public int pop() {
       return que.pollFirst();
    }
    
    public int top() {
        return que.peekFirst();
    }
    
    public boolean empty() {
        return que.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)
