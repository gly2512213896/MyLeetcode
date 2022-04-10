package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * 思路：
 * 1. 从叶子结点开始，判断当前结点的左子树left和右子树right中是否包含p或者q
 * 2. 如果left或right是p或者q结点或者子分支包含p、q则把包含的那个left或者right返回
 * 3. 不是或者不包含则返回null
 * 4. 要是发现left和right都包含，那么当前结点就为最近公共结点，返回它即可,所以我们需要在代码逻辑中让它一直上抛
 * 5. 此时另一边则会一直返回null
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 到达底部直接返回不用说（即root==null）
        // 要是找到了p或者q也直接返回
        if(root==q||root==p||root==null) return root;
        // 通过左右子树判断当前结点是不是要找的最小公共祖先（如果包含则会拿到那个p或者q）
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        // 如果找到了，就是，直接返回当前结点（那么在这之后的回溯中另一棵子树就会一直返回null）
        if(left!=null&&right!=null) return root;
        // 如果没找到，就不是，返回另一边（可能找到也可能没找到）
        if(left==null) return right;
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
