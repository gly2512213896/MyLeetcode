package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
<<<<<<< HEAD
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

import javax.management.MXBean;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 思路：
 * 1. 根据二叉搜索树的性质，相等的数在中序遍历的时候一定是连续的
 * 2. 那么就可以在一次遍历过程中统计出最大的词频（因为换词了就意味着和它相等的数没了）
 * 3. 由于可以在遍历的过程中就知道哪个频率最高，而非先遍历一遍统计所有词的频率，所以本解法可以不用map
 */
class Solution {
    public int[] findMode(TreeNode root) {
        TreeNode cur=root;
        TreeNode pre=null;
        List<Integer> resList=new ArrayList<>();
        int curCount=0;
        int maxCount=0;

        // 迭代法需要用到栈
        Stack<TreeNode> stack=new Stack<>();
        // 因为push结点的逻辑只能在循环内部，所以还需要cur!=null来启动循环
        while(cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                cur=stack.pop();
                if(pre==null||pre.val!=cur.val){
                    curCount=1;
                }else curCount++;

                if(curCount> maxCount){
                    resList.clear();
                    resList.add(cur.val);
                    maxCount=curCount;
                }else if(curCount==maxCount){
                    resList.add(cur.val);
                }
                // 先给pre赋值
                pre=cur;
                // 当前结点做完之后进行位移
                cur=cur.right;
            }
        }
        return resList.stream().mapToInt(Integer::intValue).toArray();
=======
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
 * 1. 遍历二叉树，统计每个出现的字符的频率
 */
class Solution {
    public int[] findMode(TreeNode root) {

>>>>>>> 73cd44600e20db7c578822c7063e5f8e6beff0bf
    }
}
//leetcode submit region end(Prohibit modification and deletion)
