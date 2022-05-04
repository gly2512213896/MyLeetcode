package leetcode.editor.cn.nodebugger;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Deque<Integer> path=new ArrayDeque<>();
    List<List<Integer>> result=new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums,0);
        return result;
    }
    void backtracking(int[] nums,int startIdx){
        result.add(new LinkedList<>(path));
        // 因为为void，所以要是越界了栈溢出了之类的会自动终止,可以不写终止条件
        if(nums.length==startIdx) return;
        for (int i = startIdx; i < nums.length; i++) {
            // 进入递归后的第一个数就不是同一层了，还是得要的；之后的就可以不要了
            if(i>startIdx&&nums[i]==nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
