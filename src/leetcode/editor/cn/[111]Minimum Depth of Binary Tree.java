package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;

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
    public int minDepth(TreeNode root) {
        int depth=0;
        if(root==null) return 0;
        if(root.left!=null&&root.right==null)
            depth=minDepth(root.left)+1;
        if(root.left==null&&root.right!=null)
            depth=minDepth(root.right)+1;
        else depth=Math.min(minDepth(root.left),minDepth(root.right))+1;
        return depth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
