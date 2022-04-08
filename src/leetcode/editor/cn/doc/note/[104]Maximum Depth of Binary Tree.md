# Method 1: Level traversal
ideas:
1. Same as \[102].

code:
```java
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        Deque<TreeNode> deque=new ArrayDeque<>();
        deque.offerLast(root);
        int depth=0;
        while (!deque.isEmpty()){
            depth++;
            int size=deque.size();
            TreeNode cur;
            for (int i = 0; i < size; i++) {
                cur=deque.pollFirst();
                if(cur.left!=null) deque.offerLast(cur.left);
                if(cur.right!=null) deque.offerLast(cur.right);
            }
        }
        return depth;
    }
}
```

方法二：递归（后序遍历）

思路：
1. 传入根结点
2. 递归找出左子树和右子树中的最大深度
3. 终止条件可以从null结点看起，单层的递归逻辑可以从叶子结点看起。本题终止条件是null结点的最大深度为0，
单层的递归逻辑为**每棵树的最大深度都为其子树的最大深度+1**

代码：
```java
class Solution {
    public int maxDepth(TreeNode root) {
        return getDepth(root);
    }
    int getDepth(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftDepth=getDepth(node.left);
        int rightDepth=getDepth(node.right);
        int depth=leftDepth>rightDepth?leftDepth:rightDepth;
        return depth+1;
    }
}
```
精简后：
```java
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
```

# 方法三：递归（前序遍历）
思路：
1. 将最大深度作为一个全局变量，每当有一个新的最大深度出现就更改它的值
2. 先序遍历，先比较当前层的最大深度，再判断左右子树有无更深的深度

```java
class Solution {
    int result;
    public int maxDepth(TreeNode root) {
        result=0;
        return getDepth(root,result+1);
    }
    int getDepth(TreeNode node,int depth){
        result=result>depth?result:depth;
        if(node==null) return 0;
        if(node.left!=null) getDepth(node.left,depth+1);
        if(node.right!=null) getDepth(node.right,depth+1);
        return result;
    }
}
```