# Method 1: Use deque
ideas:
1. Put every level's last element into the result set.

code:
```java
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> deque=new ArrayDeque<>();
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        deque.offerFirst(root);
        while(!deque.isEmpty()){
            int size=deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur=deque.pollFirst();;
                if(i==size-1) res.add(cur.val);
                if(cur.left!=null) deque.offerLast(cur.left);
                if(cur.right!=null) deque.offerLast(cur.right);
            }
        }
        return res;
    }
}
```