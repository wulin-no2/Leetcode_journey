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
    public int maxDepth(TreeNode root) {
        //0206: level order
        /*
        int res = 0;
        if(root == null) return res;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                TreeNode temp = q.poll();
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            res++;
        }
        return res;
        */
        
        
        
        
        // analyze:
        // d(root) = d(child) + 1;
        // we use recursive approach:
        // time and space complexity is O(n)
        /*
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        */
        
        // now we try to do it in iterative approach:
        // DFS, use stack;
        /* no!!! I can't do it T-T
        if(root == null){
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        // for each node: if it has children, h++, push children into stack; until stack is null;
        int h = 1;
        stack.push(root);
        TreeNode temp = null;
        while(! stack.isEmpty()){
            temp = stack.pop();
            if(temp.left != null && temp.right != null){
                h++;
                stack.push(temp.left);
                stack.push(temp.right);
            }else if(temp.left != null && temp.right == null){
                h++;
                stack.push(temp.left);
            }else if(temp.left == null && temp.right != null){
                h++;
                stack.push(temp.right);
            }else{
                continue;
            }
        }
        return h;
        */
        
        // see others:
        // DFS:
        /*
        if(root == null) {
        return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int temp = value.pop();
            max = Math.max(temp, max);
            if(node.left != null) {
                stack.push(node.left);
                value.push(temp + 1);
            }
            if(node.right != null) {
                stack.push(node.right);
                value.push(temp + 1);
            }
        }
        return max;
        */
        
        
        
        // BFS:
        // /*solution before:
        if(root == null) {
        return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
        // */
    }
}