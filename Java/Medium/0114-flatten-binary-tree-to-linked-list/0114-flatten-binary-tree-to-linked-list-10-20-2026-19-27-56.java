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
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> lst = new ArrayList<>();
        inorder(root, lst);

        for(int i=0; i<lst.size()-1; i++){
            TreeNode curr = lst.get(i);
            curr.left = null;
            curr.right = lst.get(i+1);
        }

    }

    public ArrayList<TreeNode> inorder(TreeNode root, ArrayList<TreeNode> lst){
        if(root==null){
            return null;
        }
       lst.add(root);
       inorder(root.left,lst);
       inorder(root.right, lst);
return lst;

    }
}