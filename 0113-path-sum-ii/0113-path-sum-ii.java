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
    // 2024.2.26
    
    private void dfs(TreeNode node, List<Integer> list, List<List<Integer>> res, int target){
        if(node==null) return; 
        list.add(node.val);
        target-=node.val;
        //System.out.println(list);
        if(node.left==null && node.right==null && target == 0){res.add(new ArrayList(list));}
        dfs(node.left, list, res, target);
        dfs(node.right, list, res, target);
        list.remove(list.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, list, res, targetSum);
        return res;
    }
    
    
    /*
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // recursive, but have to see how to store res;
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        List<Integer> list = new ArrayList<>();
        preorder(root, targetSum, res, list);
        return res;
    }
    private void preorder(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> list){
        list.add(root.val);
        System.out.println(list);
        // if it's leaf
        if(root.left==null && root.right==null){
            // if found it
            if(targetSum==root.val) res.add(new ArrayList<>(list));
            return;
        }
        // if it's not leaf
        if(root.left != null) {
            preorder(root.left, targetSum-root.val,res,list);
            list.remove(list.size()-1);
        }
        if(root.right != null) {
            preorder(root.right, targetSum-root.val,res,list);
            list.remove(list.size()-1);
        }
    }
    */
    
    // solution 2
    /*
    List<List<Integer>> result;
    LinkedList<Integer> path;
    public List<List<Integer>> pathSum (TreeNode root,int targetSum) {
        result = new LinkedList<>();
        path = new LinkedList<>();
        travesal(root, targetSum);
        return result;
    }
    private void travesal(TreeNode root,  int count) {
        if (root == null) return;
        path.offer(root.val);
        count -= root.val;
        if (root.left == null && root.right == null && count == 0) {
            result.add(new LinkedList<>(path));
        }
        travesal(root.left, count);
        travesal(root.right, count);
        path.removeLast(); // 回溯
    }
    */
    
}