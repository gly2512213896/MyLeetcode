package leetcode.editor.cn.nodebugger;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> path=new LinkedList<>();
    List<List<Integer>> result=new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);//重要
        backtracking(candidates,target,0,0);
        return result;
    }
    void backtracking(int[] candidates,int target,int sum,int startIdx){
//        if(sum>target) return ;
        if(sum==target){
            result.add(new LinkedList<>(path));
            return ;
        }
        // 虽然可以重复，但因为是组合，所以在最外层的循环单次遍历中，当前这个数字可以重复选，
        // 但是这个数字所在的那次循环遍历完之后，以后的遍历就不能再选这个数字了，因此i=startIdx而不是0
        /**
         * 原来代码：
         * for(i=0;...){
         * ...
         * backtracking(...,sum,i+1);
         * ...
         */
        //for循环剪的是宽度，递归中剪的是深度
        //涉及到大小判断，可以尝试排序之后再for循环中剪枝
        for(int i=startIdx;i<candidates.length&&sum+candidates[i]<=target;i++){
            sum+=candidates[i];
            path.add(candidates[i]);
            backtracking(candidates,target,sum,i);//可以重复，所以放i而不是i+1
            sum-=candidates[i];
            path.remove(path.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
