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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inorderIdxmp = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            inorderIdxmp.put(inorder[i],i);
        }

        return splitTree(preorder,inorderIdxmp,0,0,inorder.length-1);
    }

    private TreeNode splitTree(int[] preorder,Map<Integer,Integer> inorderIdxmp,int rootIdx,int left,int right){
        TreeNode root = new TreeNode(preorder[rootIdx]);

        int mid = inorderIdxmp.get(preorder[rootIdx]);

        if(mid>left){
            root.left = splitTree(preorder,inorderIdxmp,rootIdx+1,left,mid-1);
        }

        if(mid<right){
            root.right = splitTree(preorder,inorderIdxmp,rootIdx+mid-left+1,mid+1,right);
        }

        return root;
    }
}
