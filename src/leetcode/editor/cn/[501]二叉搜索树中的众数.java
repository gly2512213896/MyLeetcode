package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 思路：
 * 1. 根据二叉搜索树的性质，相等的数在中序遍历的时候一定是连续的
 * 2. 那么就可以在一次遍历过程中统计出最大的词频（因为换词了就意味着和它相等的数没了）
 * 3. 由于可以在遍历的过程中就知道哪个频率最高，而非先遍历一遍统计所有词的频率，所以本解法可以不用map
 */
class Solution {
    private List<Integer> resList;
    private int curCount;
    private int maxCount;
    TreeNode pre;

    public Solution() {
        resList = new ArrayList<>();
        curCount = 0;
        maxCount = 0;
        pre = null;
    }

    public int[] findMode(TreeNode root) {
        searchBST(root);
        // 需要把List转为int[]
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }

    private void searchBST(TreeNode cur) {
        if (cur == null) return;
        searchBST(cur.left);
        // 一个一个遍历，相同的频率+1，不同的就归一继续统计新词频
        if (pre == null || cur.val != pre.val) {
            curCount = 1;
        } else {
            curCount++;
        }
        // 因为是在遍历中，curCount有可能在之后会变，所以在当前结点的词频统计完后需要更新一下list中的信息
        // 出现更大的得把原本答案队列中的最高频的词（可能有多个）清空,再加入新的最高频词
        if (curCount > maxCount) {
            resList.clear();
            resList.add(cur.val);
            maxCount = curCount;
        }
        // 达到最大词频就先加入结果集,之后没有更大的就是结果了
        // 不能直接else，因为还有小于的情况
        else if (curCount == maxCount) {
            resList.add(cur.val);
        }
        pre = cur;
        searchBST(cur.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
