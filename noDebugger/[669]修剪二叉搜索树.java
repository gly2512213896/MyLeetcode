package leetcode.editor.cn.nodebugger;
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

/*

 */
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
    1. root.right代表一个结点，trimBST(root.right)代表一棵执行过递归的右子树
    2. 先写判断是否修剪的逻辑，再返回左右子树即可
 */
//class Solution {
//    public TreeNode trimBST(TreeNode root, int low, int high) {
//        if(root==null) return null;
//        // 对于遍历中的结点
//        // 删除就是不看它
//        if(root.val<low) return trimBST(root.right,low,high);
//        if (root.val>high) return trimBST(root.left,low,high);
//        // 对于根结点，子树返回了，需要接收
//        root.left=trimBST(root.left,low,high);
//        root.right=trimBST(root.right,low,high);
//        return root;
//    }
//}