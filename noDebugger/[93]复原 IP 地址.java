package leetcode.editor.cn.nodebugger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 思路：
 * 1. 从startIdx开始，for循环用于增加长度，递归用于加点，加完三个点看第四个串合不合法
 * 2. 但是for循环中不能全部加，到了某个条件之后就可以不加了，相关的判断条件写在isValid方法中
 */
class Solution {
    List<String> result=new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length()>12) return result;
        backtracking(s,0,0);
        return result;
    }
    void backtracking(String s,int startIdx,int pointNum){
        if(pointNum==3){
            if(isValid(s,startIdx,s.length()-1)){
                result.add(s);
                return ;
            }
        }
        // 一个一个加点，加到三个点的时候看第四个数字串合不合法
        for(int i=startIdx;i<s.length();i++){
            if(isValid(s,startIdx,i)){
                s=s.substring(0,i+1)+'.'+s.substring(i+1);
                backtracking(s,i+2,pointNum+1);
                s=s.substring(0,i+1)+s.substring(i+2);
            }else break;// 对于第1,2个点，如果点之后的数字串都不合法，那就不要把点再往后移了，因为肯定会更大或者也以0开头
        }
    }
    boolean isValid(String s,int start,int end){
        // 第三个点有可能出现在末尾字符之后
        if(start>end) return false;
        // 首位为0且不为单独的0
        if(s.charAt(start)=='0'&&start!=end)
            return false;
        // 大于255
        int num=0;
        for (int i = start; i <=end; i++) {
            num=num*10+s.charAt(i)-'0';
            if(num>255) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
