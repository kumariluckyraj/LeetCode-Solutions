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
    public boolean isSymmetric(TreeNode root) {
   return sym(root.left,root.right);


    }

    public boolean sym(TreeNode leftnode, TreeNode rightnode){
        if(leftnode == null && rightnode == null){
            return true;
        }
         if(leftnode == null || rightnode == null){
            return false;
        }

        if(leftnode.val!=rightnode.val){
            return false;
        }
        return sym(leftnode.left, rightnode.right) && sym(leftnode.right , rightnode.left);

    }

        
}