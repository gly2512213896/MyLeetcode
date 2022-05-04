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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur=stack.pop();
            if(cur!=null){
                if(cur.right!=null) stack.push(cur.right);
                if(cur.left!=null) stack.push(cur.left);
                stack.push(cur);
                stack.push(null);
            }
            else{
                cur=stack.pop();
                swapChildren(cur);
            }
        }
        return root;
    }
    public void swapChildren(TreeNode root){
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
