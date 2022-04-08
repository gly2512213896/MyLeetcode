package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur!=null){
                if(cur.right!=null) stack.push(cur.right);
                stack.push(cur);
                stack.push(null);
                if(cur.left!=null) stack.push(cur.left);
            }else {
                cur=stack.pop();
                res.add(cur.val);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
