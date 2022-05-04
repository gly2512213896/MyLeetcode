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

import java.util.Stack;

/**
 * 思路：
 * 1. 按照右-中-左的顺序入栈，每次判断完后（每层循环一次）就保存当前的结点的值让下一层继续判断
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st =new Stack<>();
        TreeNode cur=root;
        TreeNode pre=null;
        /**
         * 原代码：`st.push(root);`
         * 错误, 只有到达左下角之后才开始弹出数据，也只有最开始不知道哪个结点为起点的情况下需要用到root，
         * 因此不必在每次循环的时候接受当前结点（弹出栈顶），所以cur可以在循环外初始化
         */
        /**
         * 原代码：`while(!st.isEmpty()){...}`
         * 错误，如果仅由不为空来判断是否循环，由于到了叶子结点之后，下面两次循环必定会弹出两个结点，那么在
         * 第二次循环后cur会指向第二个结点的右儿子，但是假如刚好栈中只剩两个结点，那么即便右儿子有值也没法
         * 继续循环，所以得让其有值时仍然能够循环下去
         */
        while(cur!=null||!st.isEmpty()){
            /**
             * 原代码：
             * `
             * TreeNode cur=st.pop();
             * if(cur.right!=null) st.push(cur.right);
             * if(pre!=null&&cur.val<=pre.val) return false;
             * pre=cur;
             * if(cur.left!=null) st.push(cur.left);
             * `
             * 错误，由于是迭代，临时结点会先取到左儿子，然后左儿子自身再做一次放右-处理自己-放左的逻辑，
             * 而非一直到达左下角之后才开始处理
             */
            if(cur!=null){
                st.push(cur);
                cur=cur.left;
            }else{
                cur=st.pop();
                //意思是第一个结点无需判断，只需要把值赋给pre保存了即可
                if(pre!=null&&cur.val<=pre.val) return false;
                pre=cur;
                /**
                 * 原代码：`st.push(cur.right);`
                 * 错误，1. 栈只要保存了一边的所有结点，就可以顺藤摸瓜访问所有结点
                 *      2. 我们的目的是按顺序访问所有结点，所以无需将右儿子入栈，只需访问右结点即可
                 */
                cur=cur.right;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
