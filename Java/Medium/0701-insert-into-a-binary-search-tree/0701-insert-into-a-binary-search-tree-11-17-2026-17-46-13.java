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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
              TreeNode node = new TreeNode(val);
              return node;
        }
      TreeNode curr = root;
      TreeNode node = new TreeNode(val);
while(true){
      if(val<curr.val){
        if(curr.left != null){
            curr = curr.left;
        }else{
            curr.left = node;
           break;
        }
      }else{
        if(curr.right != null){
            curr = curr.right;
        }else{
            curr.right = node;
           break;
        }
      }
}
      return root;
    }
    
}