package leetcode.editor.cn.nodebugger;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> path=new LinkedList<>();
    List<List<Integer>> result=new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates,target,0,0);
        return result;
    }
    private void backtracking(int[] candidates,int target,int sum,int startIdx){
        if(target==sum){
            result.add(new LinkedList<>(path));
            return ;
        }
        // 在同一次循环中（遍历同一个candidates过程中）要跳过相同的数，
        // 但是在递归时就正常访问即可
        for(int i=startIdx;i<candidates.length&&sum+candidates[i]<=target;i++){
            // 进入后递归的第一个数要保留，不能直接去掉
            /**
             原代码：
             if(i>0&&candidates[i]==candidates[i-1])

             */
            if(i>startIdx&&candidates[i]==candidates[i-1]){
                continue;
            }
            path.add(candidates[i]);
            // 递归是要判断下一个要组合的数，从当前数下一个开始（即i+1）
            backtracking(candidates,target,sum+candidates[i],i+1);
            path.remove(path.size()-1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
