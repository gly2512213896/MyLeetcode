# Method 1: Use deque as a stack
idea:
1. No need to add left brackets.
2. If the new char didn't match `stack.peek()`, return false;
3. If `stack` is empty, return true;
4. *NullPointerException* will be thrown if `stack` is empty when adding a right bracket

code:
```java
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            //no need to push left brackets
            char c=s.charAt(i);
            if(c=='(') stack.push(')');
            else if(c=='[') stack.push(']');
            else if(c=='{') stack.push('}');
            else if(!stack.isEmpty()&&c==stack.peek()) stack.pop();
            else return false;
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

```