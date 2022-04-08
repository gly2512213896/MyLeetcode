# 方法一：递归
思路：
1. 目标和-当前结点的值=子树的目标和
2. 叶子结点即为路径上的最后一个结点，若叶子结点的值和剩余的目标和的值相等，则有答案，返回true；否则下次就会遍历到
null结点，返回false

code:
```java
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        if(root.left==null&&root.right==null&&root.val==targetSum)
            return true;
        return hasPathSum(root.left,targetSum-root.val)
                ||hasPathSum(root.right,targetSum- root.val);
    }
}
```

# 方法二：迭代法（用栈）
思路：
1. 用栈的话，接收弹出的值后直接进行判断，所以入numSt栈的值应该是下次直接进行测量的值
2. 用加法的话，需要在一开始把root.val放入numSt栈中,在每次加入左右**子**结点时把加上左右**子**结点的值后的和放入numSt栈中； 
3. 而减法的话需要在一开始把targetSum放入numSt栈中，在每次加入左右**子**结点时把减去**当前**结点的值后的和放入numSt栈中
4. 加法：第一次判断时当前结点的值已经参与“运算”，所以加上子结点；减法：第一次判断时当前结点的值未参与“运算”，所以减去当前结点
code:
```java
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        Stack<TreeNode> nodeSt=new Stack<>();
        Stack<Integer> numSt=new Stack<>();
        nodeSt.push(root);
        numSt.push(root.val);
        int curSum;
        while(!nodeSt.isEmpty()){
            TreeNode cur=nodeSt.pop();
            curSum=numSt.pop();
            if(cur.left==null&&cur.right==null&&targetSum==curSum)
                return true;
            if(cur.right!=null) {
                nodeSt.push(cur.right);
                numSt.push(curSum+cur.right.val);
            }
            if(cur.left!=null) {
                nodeSt.push(cur.left);
                numSt.push(curSum+cur.left.val);
            }
        }
        return false;
    }
}

```

code:
```java
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        Stack<TreeNode> nodeSt=new Stack<>();
        Stack<Integer> numSt=new Stack<>();
        nodeSt.push(root);
        numSt.push(targetSum);
        TreeNode cur;
        int curSum;
        while(!nodeSt.isEmpty()){
            cur=nodeSt.pop();
            curSum=numSt.pop();
            if(cur.left==null&&cur.right==null&&cur.val==curSum)
                return true;
            if(cur.right!=null) {
                nodeSt.push(cur.right);
                numSt.push(curSum-cur.val);
            }
            if(cur.left!=null) {
                nodeSt.push(cur.left);
                numSt.push(curSum-cur.val);
            }
//            if(cur.left==null&&cur.right==null&&cur.val==curNum)
//                return true;
//            if(cur.right!=null) {
//                nodeSt.push(cur.right);
//                numSt.push(curNum-cur.right.val);
//            }
//            if(cur.left!=null) {
//                nodeSt.push(cur.left);
//                numSt.push(curNum-cur.left.val);
//            }
        }
        return false;
    }
}
```