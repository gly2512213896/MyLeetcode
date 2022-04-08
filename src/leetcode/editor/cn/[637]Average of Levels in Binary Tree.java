package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> deque=new ArrayDeque<>();
        List<Double> res=new ArrayList<>();
        if(root==null) return res;
        deque.push(root);
        while(!deque.isEmpty()){
            int size=deque.size();
            TreeNode cur;
            double sum=0;
            for (int i = 0; i < size; i++) {
               cur=deque.pollFirst();
               if(cur.left!=null) deque.addLast(cur.left);
               if(cur.right!=null) deque.addLast(cur.right);
               sum+=cur.val;
            }
            double avg=sum/size;
            res.add(avg);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
