package leetcode.editor.cn.nodebugger;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    LinkedList<Integer> path=new LinkedList<>();
    List<List<Integer>> result=new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n,k,1);
        return result;
    }
    private void combineHelper(int n,int k,int startIdx){
        // 凑齐k个就终止
        if(path.size()==k){
            // 需要在找到答案之后new一个新的路径
            result.add(new LinkedList<>(path));
            return;
        }
        // 用递归让代码自动写for循环拼凑从1到n的组合
        // 剪枝：当前数i（1个）加上已经选择的数(path.size()个)再加上剩下的数（n-i个）的个数必须能凑够k个，
        //      即1+path.size()+(n-i)>=k,亦即i<=n-k+1+path.size()
        for (int i = startIdx; i <=n-k+1+path.size() ; i++) {
            path.add(i);
            // startIdx每次都是1，startIdx+1即下一层每次都会从2开始组合；
            // 而i会依次递增，每次从+1开始组合
            combineHelper(n,k,i+1);
            // 意思是每次remove之后path都是个空的
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
