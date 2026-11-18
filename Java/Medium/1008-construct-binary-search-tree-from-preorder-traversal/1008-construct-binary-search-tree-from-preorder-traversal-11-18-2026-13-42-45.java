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
    public TreeNode bstFromPreorder(int[] preorder) {
      return tree(preorder,0,preorder.length-1);

    }
   public TreeNode tree(int[] preorder, int start, int end){
    if(start>end){
        return null;
    }
    TreeNode root = new TreeNode(preorder[start]);
   
    int j = start+1;
    while(j<=end && preorder[j]<root.val){
       
        j++;
    }
    root.left = tree(preorder,start+1,j-1);
    root.right = tree(preorder, j, end);
    return root;
   }
}