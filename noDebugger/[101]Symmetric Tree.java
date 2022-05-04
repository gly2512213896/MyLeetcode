package leetcode.editor.cn.nodebugger;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }
    public boolean check(TreeNode p, TreeNode q){
        Queue<TreeNode> que=new LinkedList<>();
        que.offer(p);
        que.offer(q);
        while(!que.isEmpty()){
            p=que.poll();
            q=que.poll();
            if(p==null&&q==null){
                continue;
            }
            if((p==null||q==null)||p.val!=q.val){
                return false;
            }

            que.offer(p.left);
            que.offer(q.right);

            que.offer(p.right);
            que.offer(q.left);
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
