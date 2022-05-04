# Method 1: Use deque
ideas: 
1. Reverse the result of \[102].

code:
```java
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Collections.reverse(res);
        return res;
    }
}
```

