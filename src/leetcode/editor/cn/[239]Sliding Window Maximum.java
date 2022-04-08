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
