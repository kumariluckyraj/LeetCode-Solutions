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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> idx = new LinkedList<>();
        q.add(root);
        idx.add(0);
        int max = Integer.MIN_VALUE;
        int width =0;
        while(!q.isEmpty()){
            ArrayList<Integer> lst = new ArrayList<>();
             int first =0;
                int last =0;
            int size = q.size();

            for(int i=0; i<size; i++){
              
             TreeNode curr = q.poll();
             int index = idx.poll();
             lst.add(curr.val);
             if(i==0){
                first = index;
             }
             if(i==size-1){
                last = index;
             }
             if(curr.left != null){
                q.add(curr.left);
                idx.add(2*index);
                

             }
             if(curr.right != null){
                q.add(curr.right);
                idx.add(2*index+1);
             }

            }
            max = Math.max(max,last-first+1);
           
            
            
        }
         width = max;
        return width;
    }
}