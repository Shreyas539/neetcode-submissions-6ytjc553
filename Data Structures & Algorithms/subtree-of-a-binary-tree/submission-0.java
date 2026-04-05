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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            TreeNode node = q.poll();

            if(node.val == subRoot.val){
                if(isSameTree(node, subRoot)) return true;
            }

            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }

        return false;
    }

    private boolean isSameTree(TreeNode r,TreeNode s){
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.offer(r);
        q2.offer(s);

        while(!q1.isEmpty() && !q2.isEmpty()){
            
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();

            if(n1==null && n2==null )continue;
            if(n1==null || n2==null ) return false;
            if(n1.val !=n2.val) return false;

             q1.offer(n1.left);
           q1.offer(n1.right);
            q2.offer(n2.left);
            q2.offer(n2.right);

        }

    return q1.isEmpty() && q2.isEmpty();
    }
}
