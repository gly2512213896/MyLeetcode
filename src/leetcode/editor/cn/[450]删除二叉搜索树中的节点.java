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
 * ideas:
 * 1. only one of the two subtrees should be renewed, just the same as [701]
 * 2. so we use `root.left` or `root.right` to catch the renewed subtree
 * 3. here are the cases:
 *      1. there is no target node in the tree, and then we'll reach a null node, just return null
 *      2. we find the target:
 *          1. left and right son are both null: delete the cur and return null;
 *          2. one of them is null: return another side of cur's sons
 *          3. none of them are null: connect the cur's left son to the lower left
 *              of its right son, and return the right son
 * 4. the way of traversal is not so normal as those three traversals.
 *      here are differences:
 *          1. normal three traversals is to traverse all nodes and don't return values during their trip
 *          2. this way of traversal is not trying to change anything but letting the son node execute
 *              method itself again until reaching node that we need and then do our modification.
 *              That is, only the target node will be changed and the rest of this tree keep as it is.
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // only the target node needs to be modified
        if(root==null) return null;
        if (root.val==key) {
//            if(root.left==null&&root.right==null)
//                return null;
            if(root.left==null) return root.right;
            else if (root.right==null) return root.left;
            else {
                TreeNode cur=root.right;
                // find the lowest left leave node rather than null node
                while(cur.left!=null){
                    cur=cur.left;
                }
                cur.left=root.left;
                root=root.right;
                return root;
            }
        }
        // these above are final changes

        if(key<root.val) root.left=deleteNode(root.left,key);
        if(key>root.val) root.right=deleteNode(root.right,key);
        // not to forget the outside return
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
