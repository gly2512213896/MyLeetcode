# 方法一：递归
思路：
1. 看根结点的左右子树是否关于中心对称=》分别看两棵子树的外侧以及内侧是否相等（将同侧的结点作为递归函数的参数传递）
2. 遍历同一层的同侧结点，看它们的值是否相等，并且它们异侧的子树也得对称（递归）

代码：
```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }
    public boolean check(TreeNode p, TreeNode q){
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        return p.val==q.val&&check(p.left,q.right)&&check(p.right,q.left);

    }

}
```

#方法二：迭代
思路：
1. 同递归，不过用队列，在层序遍历的过程中**一次性放入同侧的两个结点**并进行比较。
2. 需要注意的是，如果遇到同时为空的一侧不能直接return true，因为还未遍历完所有结点。递归可以是因为递归已经帮
我们做好了，并且同时为真才返回真。
3. 同时，为假的条件是只有其中一侧为空或者同侧的俩结点值不相等。递归已经在每个子递归中判断了值是否相等所以无需
再在函数中写了。

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }
    public boolean check(TreeNode p, TreeNode q){
        Queue<TreeNode> que=new LinkedList<>();
        que.offer(p);
        que.offer(q);
        while(!que.isEmpty()){
            p=que.poll();
            q=que.poll();
            if(p==null&&q==null){
                continue;
            }
            if((p==null||q==null)||p.val!=q.val){
                return false;
            }

            que.offer(p.left);
            que.offer(q.right);

            que.offer(p.right);
            que.offer(q.left);
        }
        return true;
    }

}
```

