package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
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

import java.util.Stack;

/**
 * ideas:
 * 1. create a node on the bottom of the tree where it should be
 * 2. only one of a single node's two subtrees can insert the new node
 * 3. let the subtree, which is to be modified, recursively receive its new subtree
 *      until the lowest node is inserted
 * 4. this method can avoid create extra space for `pre`
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
//        if(root==null) return new TreeNode(val);
//        TreeNode cur=root;
//        TreeNode pre=root;
//        while(cur!=null){
//            pre=cur;
//            if(val<cur.val){
//                cur=cur.left;
//            }else{
//                cur=cur.right;
//            }
//        }
//        TreeNode node=new TreeNode(val);
//        if(val<cur.val){
//            pre.left=node;
//        }else pre.right=node;
//        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
