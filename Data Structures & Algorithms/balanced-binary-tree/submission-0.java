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
    public boolean isBalanced(TreeNode root) {
        return helper(root)>0;
    }
    private int helper(TreeNode root){
        if(root==null ){
            return 1;
        }

        int lh = helper(root.left);
        int rh = helper(root.right);

        if(lh==-1 || rh==-1 || (Math.abs(lh-rh)>1)){
            return -1;
        }

        return Math.max(lh,rh)+1;
    }
}
