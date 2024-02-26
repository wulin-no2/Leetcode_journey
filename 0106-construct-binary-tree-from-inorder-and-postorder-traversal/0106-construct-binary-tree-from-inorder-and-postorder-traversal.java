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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 1) get root from postorder;
        // 2) split inorder into 2 parts;
        // 3) split postorder into 2 parts;
        // 4) use leftinorder and leftpostorder to get left child;
        // 5) use rightinorder and rightpostorder to get right child;
        // 6) return root;
        // 1)
        if(postorder.length==0) return null;
        int val = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(val);
        if(postorder.length==1) return root;
        // 2)
        int index = -1;
        for(int i = 0 ; i < inorder.length; i++){if(inorder[i]==val) {index = i; break;}}
        int[] leftinorder = new int[index];
        int[] rightinorder = new int[inorder.length - index - 1];
        for(int i = 0 ; i < index; i++) leftinorder[i] = inorder[i];
        for(int i = index + 1 ; i < inorder.length; i++) rightinorder[i-(index + 1)] = inorder[i];
        //System.out.println("index: " + index + " leftinorder: " + leftinorder.length + " rightinorder: " + rightinorder.length);
        // 3)
        // int index1 = -1;
        // for(int i = 0 ; i < postorder.length; i++){
        //     if(index==0) break;
        //     if(postorder[i]==inorder[index-1]){
        //         index1 = i; 
        //         System.out.println("index: " + index + " leftinorder: " + leftinorder.length + " rightinorder: " + rightinorder.length + " index1: " + index1);
        //         break;
        //     }
        // }
        int[] leftpostorder = new int[leftinorder.length];
        int[] rightpostorder = new int[rightinorder.length];
        for(int i = 0 ; i < leftinorder.length; i++) leftpostorder[i] = postorder[i];
        for(int i = leftinorder.length; i < leftinorder.length + rightinorder.length; i++) rightpostorder[i-(leftinorder.length)] = postorder[i];
        //System.out.println("index: " + index + " leftinorder: " + leftinorder.length + " rightinorder: " + rightinorder.length + " index1: " + index1 + " leftpostorder: " + leftpostorder.length + " rightpostorder: " + rightpostorder.length);
        // 4)
        root.left = buildTree(leftinorder,leftpostorder);
        root.right = buildTree(rightinorder,rightpostorder);
        return root;
    }
}