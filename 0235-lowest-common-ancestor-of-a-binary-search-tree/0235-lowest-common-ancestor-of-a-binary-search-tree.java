/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // preorder. if for the 2 nodes, p>=node.val, q<node.val;or vise versa, return node; otherwise, find its child;
        if(p.val < q.val){
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        // now p.val > q.val.
        if(root.val > q.val && root.val < p.val || root.val == q.val || root.val == p.val) return root;
        else if(root.val > p.val) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);
        
        /*
        // analyze:
        // let p.val < q.val
        // for a node p 
        // if both of them < p.val,go left; both of them > p.val, go right;
        // if one >= p.val && one =< p.val, then return p;
        // we can use recursive:
        // TC = 0(nlogn), SC = 0(1)
        int max = Math.max(q.val, p.val);
        int min = Math.min(q.val, p.val);

        if(min <= root.val && max >= root.val) return root;
        // branch 1: all the left;
        if(max < root.val) return lowestCommonAncestor(root.left, p, q);
        // branch 2: all the right;
        return lowestCommonAncestor(root.right, p, q);  
        */
    }
}