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

import javax.management.Query;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
//leetcode submit region end(Prohibit modification and deletion)
