package leetcode.editor.cn.nodebugger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Deque<String> path=new ArrayDeque<>();
    List<List<String>> result=new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtracking(s,0);
        return result;
    }

    // 在同一层的递归中，startIdx是不变的，而i是会变的，所以拿startIdx判断初始长度，拿i用来增加字符串长度
    void backtracking(String s,int startIdx){
        if(startIdx>=s.length()){
            result.add(new LinkedList(path));
            return ;
        }
        // 对于"aab"，
        // 先判断第一个"a"是不是，然后进递归，判断"aa"是不是，然后再进递归，再判断"aab"是不是，
        // 然后最外层循环+1，判断第二个"a"是不是，然后进递归。。。以此类推
        for(int i=startIdx;i<s.length();i++){
            if(isPalindrome(s,startIdx,i)){
                String str=s.substring(startIdx,i+1);
                path.add(str);
            }else continue;

            backtracking(s,i+1);
            path.removeLast();
        }
    }
    boolean isPalindrome(String s,int start,int end){
        for(;start<end;start++,end--){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
