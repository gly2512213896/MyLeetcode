# Method 1: Recursion
ideas:
1. Traverse all nodes,swapping their children.
2. Inorder traversal can't be used as nodes of the left subtree will be swapped twice 
while the other won't be swapped.

code:
```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        swapChildren(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    public void swapChildren(TreeNode root){
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
    }
}
```


# Method 2: Use stack
ideas: null

code:
```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur=stack.pop();
            swapChildren(cur);
            if(cur.right!=null) stack.push(cur.right);
            if(cur.left!=null) stack.push(cur.left);
        }
        return root;
    }
    public void swapChildren(TreeNode root){
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
    }
}
```

# Method 3: Iteration
ideas:null

code:
```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur=stack.pop();
            if(cur!=null){
                if(cur.right!=null) stack.push(cur.right);
                if(cur.left!=null) stack.push(cur.left);
                stack.push(cur);
                stack.push(null);
            }
            else{
                cur=stack.pop();
                swapChildren(cur);
            }
        }
        return root;
    }
    public void swapChildren(TreeNode root){
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
    }
}
```