# 方法一：递归
思路：
1. 递归求子树中的最大深度+1
2. 每棵子树的最大深度独立，不能作为全局变量

代码：
```java
class Solution {
    public int maxDepth(Node root) {
        if(root==null) return 0;
        int depth=0;
        for (Node child : root.children) {
            depth=Math.max(depth,maxDepth(child));
        }
        return depth+1;
    }
}
```

#方法二：迭代
思路：
1. 每走一层，深度+1；
2. 每层的每个结点都得访问，将其的子结点放入队列

```java
class Solution {
    public int maxDepth(Node root) {
        if(root==null) return 0;
        Queue<Node> que=new LinkedList<>();
        que.offer(root);
        Node cur;
        int depth=0;
        while(!que.isEmpty()){
            int levelSize=que.size();
            depth++;
            for (int i=0;i<levelSize;i++) {
                cur=que.poll();
                for (Node child : cur.children) {
                    if(child!=null) que.offer(child);
                }
            }
        }
        return depth;
    }
}
```