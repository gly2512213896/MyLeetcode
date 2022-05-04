package leetcode.editor.cn.nodebugger;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Deque<Integer> path=new ArrayDeque<>();
    List<List<Integer>> result=new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums,0);
        return result;
    }
    private void backtracking( int[] nums, int startIdx ) {
        //一进递归就把数放进结果，因为在进递归之前已经判断是合理的了。当然长度得大于2
        if(path.size()>1){
            result.add(new LinkedList<>(path));
        }
//        int[] used =new int[201];
        HashMap<Integer,Integer> used=new HashMap<>();
        for (int i = startIdx; i < nums.length; i++) {
//            used[nums[i]+100]==1
            if(!path.isEmpty()&&nums[i]<path.getLast()||used.getOrDefault(nums[i],0)>=1){
                continue;
            }
//            used[nums[i]+100]=1;
            used.put(nums[i],used.getOrDefault(nums[i],0)+1);
            path.add(nums[i]);
            backtracking(nums, i+1);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
