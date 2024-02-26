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
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
        
    }
    /*
    private void dfs(TreeNode node, String s, List res){
        if(s.equals("")) s = s + node.val;
        else s = s + "->" + node.val;
        if(node.left==null && node.right==null) {res.add(s); return;}
        if(node.left!=null){dfs(node.left, s, res);}
        if(node.right!=null){dfs(node.right, s, res);}
    }
    */
    
    // we can use StringBuilder() to make it faster;
    private void dfs(TreeNode node, String s, List res){
        if(s.equals("")) s = new StringBuilder(s).append(node.val).toString();
        else s = new StringBuilder(s).append("->").append(node.val).toString(); 
        if(node.left==null && node.right==null) {res.add(s); return;}
        if(node.left!=null){dfs(node.left, s, res);}
        if(node.right!=null){dfs(node.right, s, res);}
    }
    
    /*
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        deal(root, "");
        return result;
    }

    public void deal(TreeNode node, String s) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            result.add(new StringBuilder(s).append(node.val).toString());
            return;
        }
        String tmp = new StringBuilder(s).append(node.val).append("->").toString();
        deal(node.left, tmp);
        deal(node.right, tmp);
    }
    */
}

