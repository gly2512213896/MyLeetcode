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


class Solution {
    /**
     * 1. 根据上下界找数组中的最大值
     * 2. 找其左边和其右边的最大值，将其制成结点接在上面
     * 3. 根据左右子树各自的上下边界递归制作结点
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length-1);
    }
    TreeNode construct(int[] nums,int left,int right){
        /*
            总结：根据区间构建二叉树时，是一个结点一个结点地构建。一般都有一边不会变，然后另一边是一格一格地
            增加（或减少），如果改变的这边和另一边重合，就意味着只剩下边界的那个结点可以构建了。若继续往后，则
            为空节点了。
         */
        if(left>right) return null;
        int rootIdx=maxIdx(nums,left,right);
        TreeNode root=new TreeNode(nums[rootIdx]);
        root.left=construct(nums,left,rootIdx-1);
        root.right=construct(nums,rootIdx+1,right);
        return root;
    }
    int maxIdx(int[] nums,int left,int right){
        int maxIdx=left;
        for (int i = left; i <=right; i++) {
            if(nums[maxIdx]<nums[i]){
                maxIdx=i;
            }
        }
        return maxIdx;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
