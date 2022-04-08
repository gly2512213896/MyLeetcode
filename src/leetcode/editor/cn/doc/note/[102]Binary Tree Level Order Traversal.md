# Method 1: Use queue
ideas: null

code:
```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque=new ArrayDeque<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        deque.offerFirst(root);
        while(!deque.isEmpty()){
            int size=deque.size();
            ArrayList<Integer> itemList=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur=deque.pollFirst();;
                itemList.add(cur.val);
                if(cur.left!=null) deque.offerLast(cur.left);
                if(cur.right!=null) deque.offerLast(cur.right);
            }
            res.add(itemList);
        }
        return res;
    }
}
```