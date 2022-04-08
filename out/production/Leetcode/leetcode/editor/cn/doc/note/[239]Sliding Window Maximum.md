# Method 1: Use Deque
ideas:
1. Use Deque to receive and judge every sliding window's maximum.
2. Requirements of `deque` that we need:
>       1. Exit is always the greatest so that whenever the popped is the greatest of a 
>       sliding window.
>       2. The sequence are in order (from big to small) so that the exit is still the
>       greatest when current exit is removed due to expiration or the greater appearing.
2. To create such a `deque`, we need:
>       1. Poll the exit (from front) only when it expire, and the sequence is determined
>       by *add* function.
>       2. Removed those elements which is less than the new num (from back, because
>       there may still be some elements greater than the new num, and the greater 
>       should be followed by the less).
>       3. If the new num don't greater than anyone in `deque`, directly add it (because
>       there may be no bigger nums after this and nums before it is exhausted(消耗完了)).
4. Do these things when going to next sliding windows:
>       1. Add the latest num of the sliding window, and whether it need to be add 
>       to `deque` will be automatically done by `deque` itself.
>       2. Remove the earliest num of the sliding window, and whether it need to be 
>       remove from `deque` will be automatically do by `deque` itself.
>       3. Receive the maximum from the `deque` of its exit.

code:
```java
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
//leetcode submit region begin(Prohibit modification and deletion)
class MyQue{
    Deque<Integer> deque=new LinkedList<>();
    public void poll(int value){
        if(!deque.isEmpty()&&value==deque.peekFirst()){
            deque.pollFirst();
        }
    }
    public void add(int value){
        while(!deque.isEmpty()&&value>deque.peekLast()){
            deque.pollLast();
        }
        deque.addLast(value);
    }
    public int peek(){
        return deque.peekFirst();
    }

}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==1) return nums;
        int len=nums.length-k+1;
        int count=0;
        MyQue que=new MyQue();
        int[] res=new int[len];
        for (int i = 0; i < k; i++) {
            que.add(nums[i]);
        }
        res[count++]=que.peek();
        for(int i=k;i<nums.length;i++){
            que.poll(nums[i-k]);
            que.add(nums[i]);
            res[count++]=que.peek();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

```