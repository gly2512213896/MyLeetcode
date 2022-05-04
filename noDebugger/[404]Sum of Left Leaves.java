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
    public int sumOfLeftLeaves(TreeNode root) {
       Stack<TreeNode> nodes=new Stack<>();
       if(root==null) return 0;
       nodes.push(root);
       int sum=0;
       while(!nodes.isEmpty()){
           TreeNode cur=nodes.pop();
           if(cur.left!=null&&cur.left.left==null&&cur.left.right==null){
               sum+=cur.left.val;
           }
           if(cur.right!=null) nodes.push(cur.right);
           if(cur.left!=null) nodes.push(cur.left);
       }
       return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
