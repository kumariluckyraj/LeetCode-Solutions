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
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> lst = new ArrayList<>();
        inorder(root, lst);
       TreeNode first = null;
        TreeNode second = null;
        for(int i=0; i<lst.size()-1; i++){
            if(lst.get(i).val>lst.get(i+1).val){
                if(first==null){
                    first = lst.get(i);
                    second = lst.get(i+1);
                }else{
                    second = lst.get(i+1);
                }
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
      


    }
    public void inorder(TreeNode node, ArrayList<TreeNode> lst){
        if(node == null){
            return;
        }
        inorder(node.left, lst);
        lst.add(node);
        inorder(node.right, lst);
    }
}