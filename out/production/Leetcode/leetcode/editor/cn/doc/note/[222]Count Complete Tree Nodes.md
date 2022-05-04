# 方法一：递归
思路：
1. 无

代码：
```java
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
```

# 方法二：迭代
思路：
1. 若没有孩子，不能将null加入队列

代码：
```java
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> que=new LinkedList<>();
        int count=0;
        que.offer(root);
        TreeNode cur;
        while(!que.isEmpty()){
            int queSize=que.size();
            for (int i = 0; i < queSize; i++) {
                cur=que.poll();
                count++;
                if(cur.left!=null) que.offer(cur.left);
                if(cur.right!=null) que.offer(cur.right);
            }
        }
        return count;
    }
}
```

# 方法三：公式法
思路：
1. 满二叉树的结点个数：2^n-1
2. 先看根结点，判断左右子树是否高度相等，高度相等则为满二叉树（题目已经说了是完全二叉树）
3. 若不相等，则递归让左右子树各自找结点数，最后两者相加再+1；

代码：
```java
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        TreeNode left=root.left;
        TreeNode right=root.right;
        int leftDepth=0,rightDepth=0;
        while(left!=null){
            left=left.left;
            leftDepth++;
        }
        while(right!=null){
            right=right.right;
            rightDepth++;
        }
        if(leftDepth==rightDepth){
            return (2<<leftDepth)-1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
```