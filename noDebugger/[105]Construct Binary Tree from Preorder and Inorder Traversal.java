package leetcode.editor.cn.nodebugger;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen=preorder.length;
        int inLen=inorder.length;
        int i=0;
        Map<Integer,Integer> inMap= new HashMap<>();
        //需要根据值来找中序遍历中的下标，所以value为下标
        for (int val : inorder) {
            inMap.put(val,i++);
        }
        return buildTree(0,preLen-1,0,inLen-1,inMap,preorder);
    }

    /*
        递归构建子树的过程中，并不需要用到inorder数组，因为只需要找到根结点在inorder数组中的下标，其左边为
        左子树，右边为右子树，就可以进行下一次递归，而不需要具体的值。这点inMap就可以做到
     */
    private TreeNode buildTree(int preLeft, int preRight, int inLeft, int inRight,
                               Map<Integer, Integer> inMap,int[] preorder) {
        if(preLeft>preRight||inLeft>inRight) return null;
        int rootVal=preorder[preLeft];
        TreeNode root=new TreeNode(rootVal);
        int inIdx=inMap.get(rootVal);
        root.left=buildTree(preLeft+1,preLeft+inIdx-inLeft,inLeft, inIdx-1,
                inMap,preorder);
        root.right=buildTree(preLeft+inIdx-inLeft+1,preRight,inIdx+1,inRight,
                inMap,preorder);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
