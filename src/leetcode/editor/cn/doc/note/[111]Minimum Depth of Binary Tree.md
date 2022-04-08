# Method 1: Level traversal
ideas:
1. Same as \[102].

code:
```java
class Solution {
    public int minDepth(TreeNode root) {
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
                if(cur.left==null&&cur.right==null) return depth;
                if(cur.left!=null) deque.offerLast(cur.left);
                if(cur.right!=null) deque.offerLast(cur.right);
            }
        }
        return depth;
    }
}
```

# 方法二：递归
思路：
1. 由于空节点会直接返回0，因此左子树和右子树的最小深度得分开返回，不然只return depth+1或者令depth+1 
，叶子结点的高度就会接受为0而非正确的1，但每次两个都搞，又会···在左右子树都在的时候会重复计算.以下代码为错误示例：
```java
class Solution {
    public int minDepth(TreeNode root) {
        int depth=0;
        if(root==null) return 0;
        if(root.left!=null&&root.right==null)
            depth=minDepth(root.left)+1;
        if(root.left==null&&root.right!=null)
            depth=minDepth(root.right)+1;
        else depth=Math.min(minDepth(root.left),minDepth(root.right))+1;
        return depth;
    }
}
```

正确代码：
```java
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int leftDepth=minDepth(root.left);
        int rightDepth=minDepth(root.right);
        if(root.left!=null&&root.right==null)
            return leftDepth+1;
        if(root.left==null&&root.right!=null)
            return rightDepth+1;
        return Math.min(leftDepth,rightDepth)+1;
    }
}
```