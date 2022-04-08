# Method 1: Recursion
ideas:
1. Same as [144].

code:
```java

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        postorder(root,res);
        return res;
    }
    public void postorder(TreeNode cur,List<Integer> res){
        if(cur==null)
            return ;
        postorder(cur.left,res);
        postorder(cur.right,res);
        res.add(cur.val);
    }
}
```
# Method 2: Iteration(Use stack)
ideas:
1. Same as \[144]

code:
```java
import java.util.*;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root==null) return res;
        /*
            the first visited node need to be dealt with,
            so put it into stack directly
        */
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur=stack.pop();
            res.add(cur.val);
            if(cur.left!=null) stack.push(cur.left);
            if(cur.right!=null) stack.push(cur.right);
        }
        Collections.reverse(res);
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
                stack.push(cur);
                stack.push(null);
                if(cur.right!=null) stack.push(cur.right);
                if(cur.left!=null) stack.push(cur.left);
            }else {
                cur=stack.pop();
                res.add(cur.val);
            }
        }
        return res;
    }
}
```
