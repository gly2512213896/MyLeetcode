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
    int result;
    public int maxDepth(TreeNode root) {
        result=0;
        return getDepth(root,result+1);
    }
    int getDepth(TreeNode node,int depth){
        result=result>depth?result:depth;
        if(node==null) return 0;
        if(node.left!=null) getDepth(node.left,depth+1);
        if(node.right!=null) getDepth(node.right,depth+1);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
