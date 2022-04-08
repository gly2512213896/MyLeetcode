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
