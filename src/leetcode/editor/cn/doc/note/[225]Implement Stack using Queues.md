# Method 1: Use two queues
ideas:
1. When popping, poll all nums except the newest num of `que1` into `que2`, pop 
up the pop-needed num of que1, and then re-add all nums of `que2` into `que1`
2. Convert the sequence of `que1` to stack at time of putting `x` into it

code:
```java
import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class MyStack {
    Queue<Integer> que1;
    Queue<Integer> que2;
    public MyStack() {
        que1=new LinkedList<>();
        que2=new LinkedList<>();
    }

    public void push(int x) {
        que1.add(x);
    }

    public int pop() {
        int size=que1.size();
        size--;
        while(size-->0){
            que2.offer(que1.poll());
        }
        while(!que2.isEmpty()){
            que1.offer(que2.poll());
        }
        return que1.poll();
    }

    public int top() {
        int res= pop();
        que1.offer(res);
        return res;
    }

    public boolean empty() {
        return que1.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
```

# Method 2: Use two deques
ideas:
1. Grandpa interface can't use method of his grandson instance.

code:
```java
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class MyStack {
    Deque<Integer> que1;
    Deque<Integer> que2;
    public MyStack() {
        que1=new ArrayDeque<>();
        que2=new ArrayDeque<>();
    }

    //convert the sequence of `que1` to stack at time of putting x into it
    public void push(int x) {
        que2.offerFirst(x);
        while(!que1.isEmpty()){
            que2.offerLast(que1.pollFirst());
        }
        Deque<Integer> tmp;
        tmp=que1;
        que1=que2;
        que2=tmp;
    }

    public int pop() {
        return que1.pollFirst();
    }

    public int top() {
        return que1.peek();
    }

    public boolean empty() {
        return que1.isEmpty();
    }
}


//leetcode submit region end(Prohibit modification and deletion)

```
# Method 3: Use one deque
ideas:
1. Enqueue `x` to `que`
2. When pushing, pop the first of `que` and add it to the last for `que.size()-1` times. 
Then the first would be the pop-needed.
3. Change the sequence at popping is OK too.
code:
```java
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

    //convert the sequence of `que` to stack at time of putting x into it
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
//leetcode submit region end(Prohibit modification and deletion)

```