# Method 1: Use deque
ideas:
1. Level traversal, find out the first node of each layer.
2. Then traverse all nodes, point its `next` to next node by using two indices.

code:
```java
class Solution {
    public Node connect(Node root) {
        Deque<Node> deque=new ArrayDeque<>();
        if(root==null) return root;
        deque.offerLast(root);
        while(!deque.isEmpty()){
            int size=deque.size();
            Node cur=deque.pollFirst();
            Node next;
            if(cur.left!=null) deque.offerLast(cur.left);
            if(cur.right!=null) deque.offerLast(cur.right);
            for (int i = 1; i < size; i++) {
                next=deque.pollFirst();
                cur.next=next;
                cur=next;
                if(next.left!=null) deque.offerLast(next.left);
                if(next.right!=null) deque.offerLast(next.right);
            }
            cur.next=null;
        }
        return root;
    }
}
```