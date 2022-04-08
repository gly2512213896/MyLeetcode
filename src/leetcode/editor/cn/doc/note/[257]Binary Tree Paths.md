# 方法一：递归
思路：
1. 递归需要传递的参数：当前访问的顶点、当前访问的路径、结果集
2. 递归遍历每个顶点，先将顶点的值加入当前访问的路径，然后判断是否为叶子结点
若是，则将访问路径转为String并加入结果集，否则需要加上一个"->"后，继续递归遍历它的左子树和右子树。

代码：
```java
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<>();
        traversal(root,"",result);
        return result;
    }
    public void traversal(TreeNode node,String path,List<String> paths){
        if(node==null) return ;
        StringBuffer pathSB=new StringBuffer(path);
        pathSB.append(Integer.toString(node.val));
        if(node.left==null&&node.right ==null) {
            paths.add(pathSB.toString());
        }else{
            pathSB.append("->");
            traversal(node.left,pathSB.toString(),paths);
            traversal(node.right,pathSB.toString(),paths);
        }
    }
}
```

# 方法二：用栈(先序遍历)
思路：
1. 遍历每个结点，一个一个加上箭头，到头了就加入答案。
2. 先处理访问结点，然后再按右左的顺序入栈，出栈就是左右，即按照中左右的顺序遍历整个二叉树。
3. 每次都将完整的路径加上当前访问的结点作为新的整体放入路径栈，以便回溯。

代码如下：
```java
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        Stack<TreeNode> treeStack=new Stack<>();
        Stack<String> pathStack=new Stack<>();
        List<String> paths=new ArrayList<>();
        if(root==null) return paths;
        treeStack.push(root);
        pathStack.push(Integer.toString(root.val));
        TreeNode cur;
        String path;
        while(!treeStack.isEmpty()){
            cur=treeStack.pop();
            path=pathStack.pop().toString();
            if(cur.left==null&&cur.right==null){
                paths.add(path);
            }
            if(cur.right!=null){
                treeStack.push(cur.right);
                pathStack.push(path+"->"+Integer.toString(cur.right.val));
            }
            if(cur.left!=null){
                treeStack.push(cur.left);
                pathStack.push(path+"->"+Integer.toString(cur.left.val));
            }
        }
        return paths;
    }
}
```

#方法三：迭代（广度优先）
思路：
1. 把非叶子结点每个结点加上箭头加入到当前路径中作为整体，再把新的路径加入到队列中
2. 即如果当前遍历的结点是叶子结点就直接弹出来加入答案，若非叶子结点就得把整条路径弹出来然后继续修改后重新
加入队列，等到之后再继续添加结点。

代码：
```java
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths=new ArrayList<>();
        if(root==null) return paths;
        Queue<TreeNode> treeNodeQueue=new LinkedList<>();
        Queue<String> pathQueue=new LinkedList<>();
        treeNodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));
        TreeNode cur;
        String path;
        while(!treeNodeQueue.isEmpty()){
            cur=treeNodeQueue.poll();
            path=pathQueue.poll();
            if (cur.left==null&&cur.right==null) {
                paths.add(path);
            } else {//此处两种情况是对立事件，所以用else隔开
                if(cur.left!=null){
                    treeNodeQueue.offer(cur.left);
                    pathQueue.offer(new StringBuffer(path).append("->").
                            append(cur.left.val).toString());
                }
                if(cur.right!=null){
                    treeNodeQueue.offer(cur.right);
                    pathQueue.offer(new StringBuffer(path).append("->").
                            append(cur.right.val).toString());
                }
            }
        }
        return paths;
    }
}
```