# Method 1: Use PriorityQueue
ideas:
1. [Lambda](https://zhuanlan.zhihu.com/p/348680314) :simplifying
implementing functional interface(函数式接口).
2. [top pile](https://www.cnblogs.com/lanhaicode/p/10546257.html)
3. small top pile(小顶堆) ---> ascending --->greater ---> left-right>0<br>
   big top pile(大顶堆) ---> descending --->less --->left-right<0

code1: small top pile
```java
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
   public int[] topKFrequent(int[] nums, int k) {
      int[] res=new int[k];
      HashMap<Integer,Integer> map=new HashMap<>();
      for (int num : nums) {
         map.put(num,map.getOrDefault(num,0)+1);
      }
      Set<Map.Entry<Integer,Integer>> entries=map.entrySet();
      //lambda is to sort elements of the PriorityQueue
      PriorityQueue<Map.Entry<Integer,Integer>> queue=
              new PriorityQueue<>(((o1, o2) -> o1.getValue()-o2.getValue()));
      for (Map.Entry<Integer, Integer> entry : entries) {
         queue.offer(entry);
         if(queue.size()>k)
            queue.poll();
      }
      for (int i = k-1; i >=0 ; i--) {
         res[i]=queue.poll().getKey();
      }
      return res;
   }
}
//leetcode submit region end(Prohibit modification and deletion)
```

code 2: big top pile(better than small)
```java
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
   public int[] topKFrequent(int[] nums, int k) {
      int[] res=new int[k];
      HashMap<Integer,Integer> map=new HashMap<>();
      for (int num : nums) {
         map.put(num,map.getOrDefault(num,0)+1);
      }
      //lambda is to sort elements of the PriorityQueue
      PriorityQueue<Map.Entry<Integer,Integer>> queue=
              new PriorityQueue<>(((o1, o2) -> o2.getValue()-o1.getValue()));
      queue.addAll(map.entrySet());
      for (int i = 0; i < k ; i++) {
         res[i]=queue.poll().getKey();
      }
      return res;
   }
}
//leetcode submit region end(Prohibit modification and deletion)
```