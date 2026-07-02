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
    private void parents(TreeNode root,Map<TreeNode,TreeNode> parentTrack,TreeNode target){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode current=q.poll();
            if(current.left!=null){
                parentTrack.put(current.left,current);
                q.offer(current.left);
            }
            if(current.right!=null){
                parentTrack.put(current.right,current);
                q.offer(current.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parentTrack=new HashMap<>();
        parents(root,parentTrack,root);
        Map<TreeNode,Boolean> visited=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
       visited.put(target,true);
       int currLevel=0;
       while(!q.isEmpty()){
        int size=q.size();
        if(currLevel==k)break;
        currLevel++;
        for(int i=0;i<size;i++){
            TreeNode curr=q.poll();
            if(curr.left!=null && visited.get(curr.left)==null){
                q.offer(curr.left);
                visited.put(curr.left,true);
            }
            if(curr.right!=null && visited.get(curr.right)==null){
                q.offer(curr.right);
                visited.put(curr.right,true);
            }
            if(parentTrack.get(curr)!=null && visited.get(parentTrack.get(curr))==null){
                q.offer(parentTrack.get(curr));
                visited.put(parentTrack.get(curr),true);
            }
        }
       }

       List<Integer> ans=new ArrayList<>();
       while(!q.isEmpty()){
        TreeNode current=q.poll();
        ans.add(current.val);
       }

       return ans;
    }
}