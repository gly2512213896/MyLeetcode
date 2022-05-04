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
//class Solution {
//    int preVal;
//    public TreeNode convertBST(TreeNode root) {
//        preVal=0;
//        traversal(root);
//        return root;
//    }
//    void traversal(TreeNode root){
//        if(root==null) return;
//        traversal(root.right);
//        root.val+=preVal;
//        preVal=root.val;
//        traversal(root.left);
//    }
//}
class Solution {
    int preVal;
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return null;
        Stack<TreeNode> nodeStack=new Stack<>();
        TreeNode cur=root;// 指向root的同一个结点
        nodeStack.push(cur);
        preVal=0;
        while(!nodeStack.isEmpty()){
            if(cur!=null){
                nodeStack.push(cur);
                cur=cur.right;
            }else{
                cur=nodeStack.pop();
                cur.val+=preVal;
                preVal=cur.val;
                cur=cur.left;
            }
        }
        return root;
    }
//    void traversal(TreeNode cur){
//        if(cur==null) return ;
//        Stack<TreeNode> nodeStack=new Stack<>();
//        while(cur!=null||!nodeStack.isEmpty()){
//            if(cur!=null){
//                nodeStack.push(cur);
//                cur=cur.right;
//            }else{
//                cur=nodeStack.pop();
//                cur.val+=preVal;
//                preVal=cur.val;
//                cur=cur.left;
//            }
//        }
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
