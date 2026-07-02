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
class Tuple{
    TreeNode node;
    int vertical;
    int level;
    public Tuple(TreeNode _node, int _vertical,int _level){
        node=_node;
        vertical=_vertical;
        level=_level;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Tuple> queue=new LinkedList<>();
        queue.offer(new Tuple(root,0,0));
        while(!queue.isEmpty()){
            Tuple tuple=queue.poll();
            TreeNode node=tuple.node;
            int x=tuple.vertical;
            int y=tuple.level;

            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);

            if(node.left!=null){
                queue.offer(new Tuple(node.left,x-1,y+1));
            }
            if(node.right!=null){
                queue.offer(new Tuple(node.right,x+1,y+1));
            }
        }

        List<List<Integer>> ans=new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys:map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes: ys.values()){
                while(!nodes.isEmpty()){
                    // System.out.println(nodes.peek());
                    ans.get(ans.size()-1).add(nodes.poll());
                }
            }
        }
        return ans;
    }
}