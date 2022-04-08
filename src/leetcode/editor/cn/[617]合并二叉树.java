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

/**
 * 思路：
 * 1. 构建一棵新树，仍然需要一个结点一个结点的创建
 * 2. 只需要将两棵树的同侧作为参数传递，构建一个新的结点，然后递归完成即可
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        /**
         * 原本代码：
         * `if(root1==null&&root2==null) return null;`
         * 出错了，原因在于null没有val值，当一边为null另一边不为null就会抛出异常
         * 在这种情况下，新的结点就是有值的结点，所以只需要把两种情况都写一遍即可。
         * 并且，即便两个同时为null，返回的仍然是null，符合要求
         */
        if(root1==null) return root2;
        if(root2==null) return root1;
        TreeNode root=new TreeNode((root1.val+root2.val));
        root.left=mergeTrees(root1.left,root2.left);
        root.right=mergeTrees(root1.right,root2.right);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
