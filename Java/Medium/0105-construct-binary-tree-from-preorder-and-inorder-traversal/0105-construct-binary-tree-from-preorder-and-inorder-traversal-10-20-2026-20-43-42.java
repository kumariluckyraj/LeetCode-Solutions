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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         HashMap<Integer, Integer> inmap = new HashMap<>();
         for(int i=0; i<inorder.length; i++){
            inmap.put(inorder[i], i);
         }
         return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inmap);
    }
    public TreeNode build(int[] preorder, int prestart,int preend, int[] inorder, int instart, int inend,  HashMap<Integer, Integer> inmap){
        
if(prestart>preend||instart>inend){
    return null;
}

        TreeNode root = new TreeNode(preorder[prestart]);
        int inroot = inmap.get(root.val);
        int left = inroot-instart;
    root.left= build(preorder,prestart+1,prestart+left,inorder,instart,inroot-1,inmap);
    root.right = build(preorder,prestart+left+1,preend,inorder,inroot+1,inend, inmap);
return root;
    }


}