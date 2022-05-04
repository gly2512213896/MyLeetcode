package leetcode.editor.cn.nodebugger;

import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    LinkedList<Integer> path=new LinkedList<>();
    List<List<Integer>> result=new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        combineHelper(k,n,0,1);
        return result;

    }
    private void combineHelper(int k,int n,int sum,int startIdx){
        if(sum>n) return ;
        if(path.size()==k){
            if(sum==n){
                //直接加path的话，后续对path的改动会影响之前的path
                //在最后path都被remove完了，所以才为空
                result.add(new LinkedList<>(path));
                return ;
            }
        }
        for(int i=startIdx;i<=9-(k-path.size())+1;i++){
            sum+=i;
            path.add(i);
            combineHelper(k,n,sum,i+1);
            path.removeLast();
            sum-=i;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
