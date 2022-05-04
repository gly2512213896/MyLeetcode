package leetcode.editor.cn.nodebugger;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Deque;
import java.util.LinkedList;
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
    List<List<Integer>> paths=new LinkedList<>();
    Deque<Integer> path=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traversal(root,targetSum);
        return paths;
    }
    void traversal(TreeNode cur,int targetNum){
        if(cur==null) return ;
        path.offerLast(cur.val);
        targetNum-=cur.val;
        if(cur.left==null&&cur.right==null&&targetNum==0) {
            paths.add(new LinkedList<>(path));
        }
        traversal(cur.left,targetNum);
        traversal(cur.right,targetNum);
        path.pollLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
