# Method 1: Recursion
ideas:
1. Put num into *Arraylist* for returning.

code:
```java
package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        preorder(root,res);
        return res;
    }
    public void preorder(TreeNode cur,List<Integer> res){
        if(cur==null)
            return ;
        res.add(cur.val);
        preorder(cur.left,res);
        preorder(cur.right,res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
```
# Method 2: Iteration(Use stack)
ideas:
1. Only when the order of push is right-left-middle, the pop's can be middle-left-right.
2. Differences between recursion(system stack) and iteration(my stack):in recursion, 
there are a few explicit son recursion, and each of them has its stack to record states, we 
traverse nodes by visiting his son node; but in iteration, we traverse all 
nodes into one single stack

code:
```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur=stack.pop();
            res.add(cur.val);
            if(cur.right!=null) stack.push(cur.right);
            if(cur.left!=null) stack.push(cur.left);
        }
        return res;
    }

}
```

# Method 3:Labelling method(标记法) to unify three traversals' code style
ideas: 
1. Same as \[94]

code:
```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur!=null){
                if(cur.right!=null) stack.push(cur.right);
                if(cur.left!=null) stack.push(cur.left);
                stack.push(cur);
                stack.push(null);
            }else {
                cur=stack.pop();
                res.add(cur.val);
            }
        }
        return res;
    }
}
```