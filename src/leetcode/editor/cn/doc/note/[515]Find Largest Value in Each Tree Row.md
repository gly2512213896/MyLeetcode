# Method 1: Use deque
ideas:
1. Same as \[102].

code:
```java
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Deque<TreeNode> deque=new ArrayDeque<>();
        if(root==null) return res;
        deque.addLast(root);
        while(!deque.isEmpty()){
            int size=deque.size();
            int max=Integer.MIN_VALUE;
            TreeNode cur;
            for (int i = 0; i < size; i++) {
                cur=deque.pollFirst();
                if(cur.left!=null) deque.addLast(cur.left);
                if(cur.right!=null) deque.addLast(cur.right);
                max=max>cur.val?max:cur.val;
            }
            res.add(max);
        }
        return res;
    }
}
```