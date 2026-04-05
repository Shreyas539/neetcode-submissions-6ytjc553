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
    int dmtr = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return dmtr;
    }
    private int height(TreeNode root){
        if(root==null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        dmtr = Math.max(lh+rh,dmtr);

        return 1+Math.max(lh,rh);
    }
    
}
