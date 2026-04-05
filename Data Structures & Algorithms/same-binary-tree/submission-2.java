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
    public boolean isSameTree(TreeNode r1, TreeNode r2) {
if (r1 == null && r2 == null)
            return true;

        if (r1 == null || r2 == null)
            return false;

        // Use two queues for level order traversal
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(r1);
        q2.add(r2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();

            // Check if the current nodes are identical
            if (node1.val != node2.val)
                return false;

            // Check the left children
            if (node1.left != null && node2.left != null) {
                q1.add(node1.left);
                q2.add(node2.left);
            } else if (node1.left != null || node2.left != null) {
                return false;
            }

            // Check the right children
            if (node1.right != null && node2.right != null) {
                q1.add(node1.right);
                q2.add(node2.right);
            } else if (node1.right != null || node2.right != null) {
                return false;
            }
        }

        // If both queues are empty, the trees are identical
        return q1.isEmpty() && q2.isEmpty();

    }
}
