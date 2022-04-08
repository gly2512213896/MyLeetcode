# Method 1: Use Deque as Stack
ideas:
1. Pop char from `stack` when matching
2. Reverse at last.

code:
```java
import java.util.Deque;
import java.util.LinkedList;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(!stack.isEmpty() &&c==stack.peek()){
                stack.pop();
            }else stack.push(c);
        }
        StringBuilder newStr=new StringBuilder();
        while(!stack.isEmpty()){
            newStr.append(stack.pop());
        }
        return newStr.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

```

# Method 2: Use String as stack
ideas:null

code:
```java

import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicates(String s) {
        StringBuffer res=new StringBuffer();
        int top=-1;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(top>-1&&c==res.charAt(top)){
                res.deleteCharAt(top);
                top--;
            }
            else {
                res.append(c);
                top++;
            }
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
```
# Method 3: Two pointers
ideas:
1. If same, use `slow` to go back 1 forward, and use `fast` to override it.
2. We put the *override* operation in the next loop in case that `fast` is out of the array 
at last.

code:
```java
import java.util.Deque;
import java.util.LinkedList;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicates(String s) {
        char[] chars=s.toCharArray();
        int fast=0;
        int slow=0;
        while(fast<s.length()){
            chars[slow]=chars[fast];
            if(slow>0&&chars[slow]==chars[slow-1]){
                slow--;
            }else slow++;
            fast++;
        }
        return new String(chars,0,slow);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

```