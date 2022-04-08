package leetcode.editor.cn;
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths=new ArrayList<>();
        if(root==null) return paths;
        Queue<TreeNode> treeNodeQueue=new LinkedList<>();
        Queue<String> pathQueue=new LinkedList<>();
        treeNodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));
        TreeNode cur;
        String path;
        while(!treeNodeQueue.isEmpty()){
            cur=treeNodeQueue.poll();
            path=pathQueue.poll();
            if (cur.left==null&&cur.right==null) {
                paths.add(path);
            } else {
                if(cur.left!=null){
                    treeNodeQueue.offer(cur.left);
                    pathQueue.offer(new StringBuffer(path).append("->").
                            append(cur.left.val).toString());
                }
                if(cur.right!=null){
                    treeNodeQueue.offer(cur.right);
                    pathQueue.offer(new StringBuffer(path).append("->").
                            append(cur.right.val).toString());
                }
            }
        }
        return paths;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
