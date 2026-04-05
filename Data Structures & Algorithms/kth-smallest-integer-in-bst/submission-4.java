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
    int count = 0;
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
         if(k <= 0) return -1;

        List<Integer> inorderRes = new ArrayList<>();

        inOrder(root, inorderRes);

        return inorderRes.get(k - 1);
    }

   public void inOrder(TreeNode root, List<Integer> res) {
        if(root == null)
            return;

        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }
}
