package leetcode.editor.cn.nodebugger;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

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
 * 1. 在遍历过程中记录上一个遍历的结点，保存最小的差值即可
 */
class Solution {
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> st=new Stack<>();
        TreeNode pre=null;
        TreeNode cur=root;
        int result=Integer.MAX_VALUE;
        //当前访问的结点和栈中的结点是分离的(cur指向有值的点，但st却空了），所以要分开判断(详见[700])
        while(cur!=null||!st.isEmpty()){
            if(cur!=null){
                st.push(cur);
                cur=cur.left;
            }else{
                cur=st.pop();
                if(pre!=null) result=Math.min(result,cur.val-pre.val);
                pre=cur;
                cur=cur.right;
            }
        }
        return result;
    }
}
//class Solution {
//    TreeNode pre;
//    Stack<TreeNode> stack;
//    public int getMinimumDifference(TreeNode root) {
//        if (root == null) return 0;
//        stack = new Stack<>();
//        TreeNode cur = root;
//        int result = Integer.MAX_VALUE;
//        while (cur != null || !stack.isEmpty()) {
//            if (cur != null) {
//                stack.push(cur); // 将访问的节点放进栈
//                cur = cur.left; // 左
//            }else {
//                cur = stack.pop();
//                if (pre != null) { // 中
//                    result = Math.min(result, cur.val - pre.val);
//                }
//                pre = cur;
//                cur = cur.right; // 右
//            }
//        }
//        return result;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
