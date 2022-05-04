package leetcode.editor.cn.nodebugger;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Deque<Integer> path=new ArrayDeque<>();
    List<List<Integer>> result=new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];
        backtracking(nums,used);
        return result;
    }
    void backtracking(int[] nums,boolean[] used){
        if(path.size()==nums.length) {
            result.add(new LinkedList<>(path));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            // 1. 除了i=0，其他和前一个相等并且前一个为false就意味着前一个数已经回溯过了，也就是用过了
            // 即在同一个for循环中第一个递归完了之后就砍掉了后面所有相同的数
            // 2. 而直接理解的话，used[i-1]=true也可以，就是用过的不能再用的意思
            // 3. 此判断只能去掉相同元素，不能判断当前元素用没用过(或者说只能看出前一个元素用没用过）
            if(i>0&&nums[i]==nums[i-1]&&used[i-1]==true){
                continue;
            }
            // 所以需要判断是否用过,例如在第一次子递归中也得从0开始遍历，要是不判断，那nums[0]又得加进结果一次
            if (used[i]==false) {
                used[i]=true;
                path.add(nums[i]);
                backtracking(nums,used);
                path.removeLast();
                used[i]=false;
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
