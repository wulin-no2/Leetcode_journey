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
    public List<Integer> postorderTraversal(TreeNode root) {
        // analyze:
        // 2 approach:
        // first, recursive: done at 22:25, Jan.7.2024
        /*
        ArrayList<Integer> arr = new ArrayList<>();
        // base case:
        if(root == null){
            return arr;
        }
        arr.addAll(postorderTraversal(root.left));
        arr.addAll(postorderTraversal(root.right));
        arr.add(root.val);
        return arr;
        */
        
        // second, iterative, use stack and LinkedList to shift values:
        /*
        List<Integer> arr = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return arr;
        }
        stack.push(root);
        TreeNode p = root;
        // 
        while(! stack.isEmpty()){
            p = stack.pop();
            arr.add(0, p.val);
            if(p.left != null){
                stack.push(p.left);
            }
            if(p.right != null){
                stack.push(p.right);
            }
        }
        return arr;
        */
        
        // we can also use Collections.reverse(arr) to reverse the result of preorder;
        
        // if not, it should be as following:
        // third approach:
        List<Integer> res = new ArrayList<Integer>();
  
          if (root == null)
            return res;

          Stack<TreeNode> s1 = new Stack<TreeNode>();
          Stack<TreeNode> s2 = new Stack<TreeNode>();

          s1.push(root);

          while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            s2.push(node);

            if (node.left != null)
              s1.push(node.left);

            if (node.right != null)
              s1.push(node.right);
          }

          while (!s2.isEmpty())
            res.add(s2.pop().val);

          return res;
        
    }
}