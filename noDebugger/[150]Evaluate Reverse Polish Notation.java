package leetcode.editor.cn.nodebugger;

import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int evalRPN(String[] tokens) {
        int len=tokens.length;
        Deque<Integer> stack=new LinkedList<>();
        for(String token : tokens) {
            if (isOpe(token)) {
                char c = token.charAt(0);
                int num1 = stack.pollLast();
                int num2 = stack.pollLast();
                if (c == '+') stack.addLast(num2 + num1);
                else if (c == '-') stack.addLast(num2 - num1);
                else if (c == '*') stack.addLast(num2 * num1);
                else stack.addLast(num2 / num1);
            }else stack.addLast(Integer.valueOf(token));
        }
        return stack.peek();
    }
    private boolean isOpe(String s){
        return s.length()==1&&(s.charAt(0)<'0'||s.charAt(0)>'9');
    }
}
//leetcode submit region end(Prohibit modification and deletion)
