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
    public boolean findTarget(TreeNode root, int k) {
     ArrayList<Integer> lst = new ArrayList<>();
     inorder(root,lst);
     for(int i=0; i<lst.size(); i++){
        for(int j=i+1; j<lst.size(); j++){
            if(lst.get(i)+lst.get(j)==k){
                return true;
            }
        }
     }
   return false;
    }
    public void inorder(TreeNode node, ArrayList<Integer> lst){
        if(node == null){
            return ;
        }
        inorder(node.left, lst);
        lst.add(node.val);
        inorder(node.right, lst);

    }

}