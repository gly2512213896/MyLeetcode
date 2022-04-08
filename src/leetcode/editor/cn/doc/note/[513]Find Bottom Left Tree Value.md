# 方法一：递归
思路:
1. 递归每个结点看看是否为叶子结点，若为叶子结点就判断是否大于目前的最深的深度
2. 由于先对左子树递归，所以达到最深深度后，最先碰到的叶子结点肯定为最左的
3. 此时就找出最左最深的结点以及其值了
```java
class Solution {
    int leftMax=0;
    int maxDepth=-1;
    void traversal(TreeNode cur,int leftDepth){
        if(cur==null) return ;
        if(cur.left==null&&cur.right==null){
            if(leftDepth>maxDepth){
                maxDepth=leftDepth;
                leftMax=cur.val;
            }
            return ;
        }
        if(cur.left!=null){
            traversal(cur.left,leftDepth+1);
        }
        if(cur.right!=null){
            traversal(cur.right,leftDepth+1);
        }
        return ;
    }
    public int findBottomLeftValue(TreeNode root) {
        traversal(root,0);
        return leftMax;
    }
}
```

# 方法二：迭代
思路：
1. 按层遍历，记录每一层的第一个数
2. 到达最后一层时（即队列为空时）返回当前层的第一个数

code：
```java
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> que=new ArrayDeque<>();
        int leftMax=Integer.MIN_VALUE;
        que.offer(root);
        while(!que.isEmpty()){
            int size=que.size();
            for(int i=0;i<size;i++){
                TreeNode cur = que.poll();
                if(i==0){
                    leftMax=cur.val;
                }
                if(cur.left!=null) que.offer(cur.left);
                if(cur.right!=null) que.offer(cur.right);
            }
        }
        return leftMax;
    }
}
```