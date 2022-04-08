# 方法一：递归
code:
```java
class Solution {
    /**
     * 1. 后序遍历数组中的最后一个结点为根结点，需要一个postIdx下标用于指出后序遍历数组中的
     * 当前子树的根结点
     * 2. 中序遍历数组中根结点左右分为左右子树，需要一个inIdx下标用于指出中序遍历数组中的
     * 当前子树的根结点
     * 3. left到inIdx-1为当前结点的左子树，inIdx+1到right为当前结点的右子树，递归1、2步即可
     */
    int postIdx;
    int[] inorder;
    int[] postorder;
    //哈希表用于查找中序遍历中的根结点
    Map<Integer,Integer> inorderMap= new HashMap<>();
    TreeNode helper(int inLeft,int inRight){
        /**
         * 1.若inLeft==inRight,则说明上一层递归中inIdx+1==inRight或者inLeft==inIdx-1，
         * 即除开根结点后的下标已经到达边缘
         * 2.那么若inLeft>inRight则说明inorder数组中的结点已经用完了，应该返回null
         */
        if(inLeft>inRight) return null;
        int rootVal=postorder[postIdx];
        TreeNode root=new TreeNode(rootVal);
        int inIdx=inorderMap.get(rootVal);
        postIdx--;
        root.right=helper(inIdx+1,inRight);
        root.left=helper(inLeft,inIdx-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder=inorder;
        this.postorder=postorder;
        this.postIdx=postorder.length-1;
        int inMapIdx=0;
        for (int val : inorder) {
            inorderMap.put(val,inMapIdx++);
        }
        return helper(0,postIdx);
    }
}
```