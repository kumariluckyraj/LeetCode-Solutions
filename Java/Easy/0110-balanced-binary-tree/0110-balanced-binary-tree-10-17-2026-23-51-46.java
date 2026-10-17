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
        if(root==null){
           return true;
        }
    int l = height(root.left);
    int r = height(root.right);
    if(Math.abs(l-r)>1){
        return false;
    }
    return isBalanced(root.left) && isBalanced(root.right);
    }
    public int height(TreeNode node){
        if(node==null){
           return 0;
        }
int lefth = height(node.left);
int righth = height(node.right);
int height = Math.max(lefth, righth)+1;
return height;
    }

    }