package leetcode.editor.cn.nodebugger;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<TreeNode> deque=new ArrayDeque<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        deque.offerFirst(root);
        while(!deque.isEmpty()){
            int size=deque.size();
            ArrayList<Integer> itemList=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur=deque.pollFirst();;
                itemList.add(cur.val);
                if(cur.left!=null) deque.offerLast(cur.left);
                if(cur.right!=null) deque.offerLast(cur.right);
            }
            res.add(itemList);
        }
        Collections.reverse(res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
