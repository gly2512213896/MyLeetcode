# 方法一：递归
思路：
1. 每访问一个结点，就把当前结点加入当前路径。
2. 对当前结点及其左右子树访问完毕之后还需要将当前结点弹出，用于在其父亲及之前结点的路径之后接着访问其右兄弟结点
看看是否有解
3. 只有在子树把答案填完之后才能弹出结点，所以只能采用后序遍历

代码：
```java
class Solution {
    List<List<Integer>> paths=new LinkedList<>();
    Deque<Integer> path=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traversal(root,targetSum);
        return paths;
    }
    void traversal(TreeNode cur,int targetNum){
        if(cur==null) return ;
        path.offerLast(cur.val);
        targetNum-=cur.val;
        if(cur.left==null&&cur.right==null&&targetNum==0) {
            paths.add(new LinkedList<>(path));
        }
        traversal(cur.left,targetNum);
        traversal(cur.right,targetNum);
        path.pollLast();
    }
}
```

# 方法二：迭代