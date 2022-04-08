# Method 1: Use deque
ideas:
1. Same as \[102].

code:
```java
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Deque<Node> deque=new ArrayDeque<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        deque.addFirst(root);
        while(!deque.isEmpty()){
            int size=deque.size();
            List<Integer> levelList=new ArrayList<>();
            Node cur;
            for (int i = 0; i < size; i++) {
                cur=deque.pollFirst();
                List<Node> children=cur.children;
                for (Node child : children) {
                    if (child!=null)
                        deque.addLast(child);
                }
                levelList.add(cur.val);
            }
            res.add(levelList);
        }
        return res;
    }
}
```