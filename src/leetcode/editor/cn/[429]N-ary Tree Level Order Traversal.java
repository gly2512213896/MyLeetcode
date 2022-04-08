package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
//leetcode submit region end(Prohibit modification and deletion)
