package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
//leetcode submit region end(Prohibit modification and deletion)
