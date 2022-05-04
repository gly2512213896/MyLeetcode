package leetcode.editor.cn.nodebugger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Deque<Integer> path=new ArrayDeque<>();
    List<List<Integer>> result=new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        return result;
    }
    void backtracking(int[] nums,int startIdx){
        result.add(new LinkedList<>(path));
//        if(startIdx>nums.length)
//            return ;
        for(int i=startIdx;i<nums.length;i++){
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
