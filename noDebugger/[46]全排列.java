package leetcode.editor.cn.nodebugger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Deque path=new ArrayDeque();
    List<List<Integer>> result=new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used=new boolean[nums.length];
        backtracking(nums,used);
        return result;
    }
    void backtracking(int[] nums,boolean[] used){
        if(path.size()==nums.length){
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]==true){
                continue;
            }
            used[i]=true;
            path.add(nums[i]);
            backtracking(nums,used);
            path.removeLast();
            used[i]=false;

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
