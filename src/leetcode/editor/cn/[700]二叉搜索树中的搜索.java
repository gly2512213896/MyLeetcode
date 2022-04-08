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
 * 1. 二叉搜索树，根据值的大小遍历左/右子树，找到符合的即可
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        /**
         * 1. while循环内就是在寻找，出while就意味着没找到
         * 2. 提前找到就要提前return，没找到就要return null
         */
        /**
         * 原代码：
         * `while(val!=root.val){}`
         * 错误，都不等于了还怎么找到等于的，while循环应该只起到遍历的作用，不应该具备筛选的功能
         * 由于走的一直是正确的路，所以只需要判断到没到叶子结点就行
         */
        while(root!=null){
            if(root.val==val) return root;
            /**
             * 注意：要找的是val在root.val中的位置，val小了就往左走，大了就往右走
             */
            root=val<root.val?root.left:root.right;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
