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
        // List<Integer> arrL = new ArrayList<>();
//         following is the recursive answer:
        // if(root != null){
        //     arrL.addAll(postorderTraversal(root.left));
        //     arrL.addAll(postorderTraversal(root.right));
        //     arrL.add(root.val);
        // }
        // return arrL;
        
//         following is the iterative answer:
        // Stack<TreeNode> stack = new Stack<>();
        // TreeNode node = root;
        // if(node != null){
        //     stack.push(root);
        // }
        // while(node != null){
        //     if(node.left != null && node.right != null){
        //         stack.push(node.right);
        //         stack.push(node.left);
        //         node = node.left;
        //     }else if(node.left != null && node.right == null){
        //         stack.push(node.left);
        //         node = node.left;
        //     }else if(node.left == null && node.right != null){
        //         stack.push(node.right);
        //         node = node.right;
        //     }else{
        //         arrL.add(stack.pop().val);
        //         node = stack.pop();
        //         stack.push(node);
        //     }
        // }
        // while(!stack.isEmpty()){
        //     arrL.add(stack.pop().val);
        // }
        // return arrL;
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while (p != null || !stack.isEmpty()) {
        if (p != null) {
            result.add(p.val);  // Add before going to children
            stack.push(p);
            p = p.right;
        } else {
            p = stack.pop();
            p = p.left;
        }
    }
    Collections.reverse(result);
    return result;
    }
}