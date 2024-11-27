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
        // use preorder to find the node.val; 
        // then use this val to find index of inorder array. cut it into 2 subtrees;
        // use index range of inorder tree to cut the preorder tree into 2 subtrees;
        // for each left trees and right trees, keep constructing trees as above;
        // so:
        // we have to find index of inorder tree easily according to its value; use a map to store the elements;
    HashMap<Integer, Integer> inorderMap = new HashMap<>();
    int preorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        preorderIndex = 0;
        return construct(preorder, 0, inorder.length - 1);
    }
    public TreeNode construct(int[] preorder, int inorderStart, int inorderEnd){
        if(inorderStart > inorderEnd) return null;
        // node
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        // divide left and right based on inorder index
        int rootIndex = inorderMap.get(rootValue);
        // left 
        root.left = construct(preorder, inorderStart, rootIndex - 1);
        
        // right
        root.right = construct(preorder, rootIndex + 1, inorderEnd);
        return root;
    }
}