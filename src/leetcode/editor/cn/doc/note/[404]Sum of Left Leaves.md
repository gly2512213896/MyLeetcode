# 方法一：递归
思路：
1. 通过父节点拿到当前的左子结点的值，再求出其与左子树、右子树所有左叶子的和

代码：
```java
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        int leftLeafVal=0;
        if(root.left!=null&&root.left.left==null&&root.left.right==null){
            leftLeafVal=root.left.val;
        }
        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right)+ leftLeafVal;
    }
}
```

# 方法二：迭代法
思路：
1. 还是要遍历所有结点判断是否为左叶子，所以可以拿栈遍历
2. 还得注意，不能将空指针放入栈中

代码：
```java
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        Stack<TreeNode> nodes=new Stack<>();
        if(root==null) return 0;
        nodes.push(root);
        int sum=0;
        while(!nodes.isEmpty()){
            TreeNode cur=nodes.pop();
            if(cur.left!=null&&cur.left.left==null&&cur.left.right==null){
                sum+=cur.left.val;
            }
            if(cur.right!=null) nodes.push(cur.right);
            if(cur.left!=null) nodes.push(cur.left);
        }
        return sum;
    }
}
```