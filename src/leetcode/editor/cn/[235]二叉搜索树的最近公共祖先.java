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
 * 1. 根据二叉搜索树的性质，两个结点的最近公共祖先的值一定比它的左结点大，比它的右结点小
 * 2. 如果p、q都比当前结点小，那么p和q都在当前结点的左子树中，我们需要在当前结点的左子树中寻找最近公共祖先；反之亦然
 * 3. 当值刚好处在二者之间，即p、q分别在左子树和右子树时，那么当前结点就为最近公共祖先，因为此时再往左或者往右，另一边都没有p或者q之一了；
 *      而在此之前遍历的结点都比当前结点更远
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(root.val>p.val&&root.val>q.val) {
                root=root.left;
            }else if(root.val<p.val&&root.val<q.val){
                root=root.right;
            }else return root;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
