package leetcode.editor.cn.nodebugger;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Queue;

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
class Solution {
    //    public TreeNode sortedArrayToBST(int[] nums) {
//        TreeNode root=traversal(nums,0,nums.length-1);
//        return root;
//    }
//    TreeNode traversal(int[] nums,int left,int right){
//        if(left>right) return null;
//        int mid=left+(right-left)/2;
//        TreeNode cur=new TreeNode(nums[mid]);
//        cur.left=traversal(nums,left,mid-1);
//        cur.right=traversal(nums,mid+1,right);
//        return cur;
//    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        Queue<TreeNode> nodeQue = new LinkedList<>();
        Queue<Integer> leftQue = new LinkedList<>();
        Queue<Integer> rightQue = new LinkedList<>();

        TreeNode root = new TreeNode();
        nodeQue.offer(root);
        leftQue.offer(0);
        rightQue.offer(nums.length - 1);

        while (!nodeQue.isEmpty()) {
            TreeNode cur = nodeQue.poll();
            int left = leftQue.poll();
            int right = rightQue.poll();
            int mid = left + (right - left) / 2;
            cur.val = nums[mid];
            /*
                1. 左边界和右边界一直没变，但是每次都要用，所以得不停地放进队列
                2. 在变的是mid，所以得根据mid判断是否越界
             */
            // 对于左区间，leftQue放左边界，rightQue放变化的mid
            // 由于先进先出，左区间始终能够拿到左边界
            if (left <=mid-1) {
                cur.left = new TreeNode();
                nodeQue.offer(cur.left);
                leftQue.offer(left);
                rightQue.offer(mid-1);
            }
            if (right >=mid+1) {
                cur.right = new TreeNode();
                nodeQue.offer(cur.right);
                leftQue.offer(mid+1);
                rightQue.offer(right);
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
