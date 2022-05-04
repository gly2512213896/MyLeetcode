package leetcode.editor.cn.nodebugger;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        Stack<TreeNode> nodeSt=new Stack<>();
        Stack<Integer> numSt=new Stack<>();
        nodeSt.push(root);
        numSt.push(targetSum);
        TreeNode cur;
        int curSum;
        while(!nodeSt.isEmpty()){
            cur=nodeSt.pop();
            curSum=numSt.pop();
            if(cur.left==null&&cur.right==null&&cur.val==curSum)
                return true;
            if(cur.right!=null) {
                nodeSt.push(cur.right);
                numSt.push(curSum-cur.val);
            }
            if(cur.left!=null) {
                nodeSt.push(cur.left);
                numSt.push(curSum-cur.val);
            }
//            if(cur.left==null&&cur.right==null&&cur.val==curNum)
//                return true;
//            if(cur.right!=null) {
//                nodeSt.push(cur.right);
//                numSt.push(curNum-cur.right.val);
//            }
//            if(cur.left!=null) {
//                nodeSt.push(cur.left);
//                numSt.push(curNum-cur.left.val);
//            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
