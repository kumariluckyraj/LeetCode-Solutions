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
    public boolean isValidBST(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
       
   inorder(root,ans);
   
    TreeSet<Integer> set = new TreeSet<>();
    for(int i=0; i<ans.size(); i++){
        set.add(ans.get(i));
    }
 List<Integer> ans2 = new ArrayList<>(set);
  
   if(ans2.equals(ans)){
    return true;
   }
   return false;
    } 
    public void inorder(TreeNode node, List<Integer> ans) {
        if(node == null) {
            return;
        }

        inorder(node.left, ans);
        ans.add(node.val);
        inorder(node.right, ans);
    }
}