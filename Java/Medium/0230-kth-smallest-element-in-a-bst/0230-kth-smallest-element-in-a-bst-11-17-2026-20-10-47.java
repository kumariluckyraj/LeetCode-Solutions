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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        ArrayList<Integer> lst = new ArrayList<>();
        inorder(root, lst);
        return lst.get(k-1);
       
    }

    public void inorder(TreeNode node, ArrayList<Integer> lst){
        if(node == null){
            return;
        }
        inorder(node.left,lst);
        lst.add(node.val);
        inorder(node.right,lst);


    }
}