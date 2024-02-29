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
    /*
    public boolean isValidBST(TreeNode root) {
        // recursive:
        // base case:
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        // we must get the rightmost value of left and leftmost value of right
        boolean l = true;
        boolean r = true;
        if(root.left != null) l = isValidBST(root.left) && (mValue(root.left, 1) < root.val);
        if(root.right != null) r = isValidBST(root.right) && (mValue(root.right, 0) > root.val);
        return l && r;
    }
    // return a BST's min or max
    private int mValue(TreeNode root, int dir){
        // dir == 0, means left, min; dir == 1, means right, max;
        // if(root == null) return null;
        if(root.left== null && root.right== null) return root.val;
        TreeNode p = root;
        if(dir == 0){
            while(p.left != null){
                p = p.left;
            }
            
        }else{
            while(p.right != null){
                p = p.right;
            }
        }
        return p.val;
    }
    */
    // an inOrder soluton:
public boolean isValidBST(TreeNode root) {
   if (root == null) return true;
   Stack<TreeNode> stack = new Stack<>();
   TreeNode pre = null;
   while (root != null || !stack.isEmpty()) {
      while (root != null) {
         stack.push(root);
         root = root.left;
      }
      root = stack.pop();
      if(pre != null && root.val <= pre.val) return false;
      pre = root;
      root = root.right;
   }
   return true;
}

    // an concise and clean version same with me:
    /*
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
   */
    
    
    
}