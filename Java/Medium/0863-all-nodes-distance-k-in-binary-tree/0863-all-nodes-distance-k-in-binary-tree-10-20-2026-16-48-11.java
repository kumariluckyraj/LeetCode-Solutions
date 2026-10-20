/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    Queue<TreeNode> q = new LinkedList<>();
    ArrayList<TreeNode> vis = new ArrayList<>();
    ArrayList<Integer> ans = new ArrayList<>();
    HashMap<TreeNode, TreeNode> map = new HashMap<>();
    parent(root, map);
    q.add(target);
    vis.add(target);
int dis =0;
    while(!q.isEmpty()){
if(dis==k){
    break;
}
int size = q.size();
for(int i=0; i<size; i++){
        TreeNode curr = q.poll();
        if(curr.left != null && !vis.contains(curr.left)){
            q.add(curr.left);
            vis.add(curr.left);
        }
        if(curr.right != null && !vis.contains(curr.right)){
            q.add(curr.right);
            vis.add(curr.right);
        }
        TreeNode par = map.get(curr);
        if(par != null && !vis.contains(par)){
            q.add(par);
            vis.add(par);
        }
        
}
dis++;
      

    }
    int size = q.size();
      for(int i=0; i<size; i++){
               ans.add(q.poll().val);
        }
      return ans;
    }
    public void parent(TreeNode node, HashMap<TreeNode, TreeNode> map){
        if(node==null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
             if(curr.left != null){
                q.add(curr.left);
            map.put(curr.left,curr);
        }

         if(curr.right != null){
            q.add(curr.right);
            map.put(curr.right,curr);
        }

        }

       
    }
}