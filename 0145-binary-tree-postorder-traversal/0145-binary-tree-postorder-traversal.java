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
        // recursive approach. 0204
        /*
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        return list;
        */
        // iterative approach.
        // postorder: add the leaf first. but need to confirm all the nodes that are not leaves should be trimed(remove their children);
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.peek();
            if(temp.right == null && temp.left == null) list.add(stack.pop().val);
            if(temp.right != null) {stack.push(temp.right); temp.right = null; }
            if(temp.left != null) {stack.push(temp.left); temp.left = null; } 
        }
        return list;
        
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
        /* List<Integer> res = new ArrayList<Integer>();
  
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
          */
        
        // my solution correctly:
        // Create an array list to store the solution result...
        /* solution before:
        List<Integer> sol = new ArrayList<Integer>();
        // Return the solution answer if the tree is empty...
        if(root==null) return sol;
        // Create an empty stack and push the root node...
        Stack<TreeNode> bag = new Stack<TreeNode>();
        bag.push(root);
        // Loop till stack is empty...
        while(!bag.isEmpty()) {
            // set peek a node from the stack...
            TreeNode node = bag.peek();
            // If the subtrees of that node are null, then pop & store the pop value into solution result...
            if(node.left==null && node.right==null) {
                TreeNode pop = bag.pop();
                sol.add(pop.val);
            }
            else {
                // Push the right child of the popped node into the stack...
                if(node.right!=null) {
                    bag.push(node.right);
                    node.right = null;
                }
                // Push the left child of the popped node into the stack...
                if(node.left!=null) {
                    bag.push(node.left);
                    node.left = null;
                }
            }
        }
        return sol;     // Return the solution list...
        */
    }
}