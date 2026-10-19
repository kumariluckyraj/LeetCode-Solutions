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
    public List<Integer> rightSideView(TreeNode root) {
       
      Queue<TreeNode> q = new LinkedList<>();
      List<Integer> lst = new ArrayList<>();
       if(root == null){
            return lst;
        }
      q.add(root);
      while(!q.isEmpty()){
        int size = q.size();
        for(int i=0; i<size; i++){
            TreeNode curr = q.poll();
            if(i==size-1){
                lst.add(curr.val);
            }
        
       if(curr.left != null){
        q.add(curr.left);
       }
        if(curr.right != null){
            q.add(curr.right);
        }
        }

      }
        
return lst;
    }
}