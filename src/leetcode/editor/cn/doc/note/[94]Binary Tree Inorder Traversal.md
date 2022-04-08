# Method 1: Recursion
ideas:
1. Same as [144]

code:
```java

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        inorder(root,res);
        return res;
    }
    public void inorder(TreeNode cur,List<Integer> res){
        if(cur==null)
            return ;
        inorder(cur.left,res);
        res.add(cur.val);
        inorder(cur.right,res);
    }
}
```

# Method 2: Iteration(Use stack)
ideas:
1. First traverse to the most bottom-left node as the first visited isn't what we need.
2. During the traversal, every node of a parent tree is the middle node of its son tree.

code:
```java
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> res=new ArrayList<>();
        /*
            the first visited node isn't what we need,
            so we don't put it into stack, just consider it
            the same as other nodes.
         */
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            res.add(root.val);
            root=root.right;
        }
        return res;
    }
}
```

# Method 3: Morris inorder traversal
ideas:
[LeetCode: method 3](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode-solutio/)
1. **core**: create a temporary path to let the last "right" can directly return to 
the current "middle".(normal inorder traversal can't do this). 
2. And the path is the symbol of finishing traverse left subtree.
3. Bottom-left node don't have left child node, but have right after creating the temp path.
4. Remember to destroy the temporary path after completing returning.

code:
```java
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        TreeNode predecessor=null;
        while(root!=null){
            if(root.left!=null){
                predecessor=root.left;
                //1.find the predecessor(every left node has its predecessor)
                while(predecessor.right!=null&&predecessor.right!=root){//problem left:what does it end up if no predecessor.right!=root
                    predecessor=predecessor.right;
                }
                //2.if right node is null, predecessor points to current root
                if(predecessor.right==null){
                    predecessor.right=root;
                    root=root.left;
                }
                //3.only when predecessor isn't null we add val (start from bottom-left)
                //pay attention to disconnect predecessor and current root
                else{
                    res.add(root.val);
                    predecessor=null;
                    root=root.right;
                }
            }
            else{
                res.add(root.val);
                root=root.right;
            }
        }
        return res;
    }
}
```

# Method 4: Labelling method(标记法) to unify three traversals' code style
ideas:
1. In the previous solution, we could not identify which is the currently accessed node if
we put the nodes on stack by order "right-middle-left".
2. So we have to first reach the node we want to process, (during visit, put the 
nodes visited on stack as they're the "middle"s that are the next to deal with), and put 
it into the result set.
3. That is, we couldn't know which is the "middle" node until we get to the bottom-left,
and we visit the "right" through visiting the "middle".
4. But in this method, we add a null as a label. Putting into result set or not can be easily
recognized. If it isn't null on the stack peek, that means it is a wrong timing(时机不对),
and we can't put it into the result set yet.

code:
```java
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur!=null){
                if(cur.right!=null) stack.push(cur.right);
                stack.push(cur);
                stack.push(null);
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