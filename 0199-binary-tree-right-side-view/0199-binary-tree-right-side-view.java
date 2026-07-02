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
class Pair {
    TreeNode node;
    int level;

    Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {

            Pair curr = queue.poll();
            TreeNode node = curr.node;
            int level = curr.level;

            // Keep updating so the last node of each level remains
            map.put(level, node.val);

            if (node.left != null)
                queue.offer(new Pair(node.left, level + 1));

            if (node.right != null)
                queue.offer(new Pair(node.right, level + 1));
        }

        for (int val : map.values()) {
            ans.add(val);
        }

        return ans;
    }
}