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
    private void buildParentMap(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                q.offer(curr.left);
            }
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }

    // Step 2: Find the node with given start value
    private TreeNode findStartNode(TreeNode root, int start) {
        if (root == null) return null;
        if (root.val == start) return root;
        TreeNode left = findStartNode(root.left, start);
        if (left != null) return left;
        return findStartNode(root.right, start);
    }

    public int amountOfTime(TreeNode root, int start) {
        if (root == null) return 0;

        // Build parent map
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, parentMap);

        // Find the start node
        TreeNode startNode = findStartNode(root, start);

        // Step 3: BFS starting from startNode
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();

        q.offer(startNode);
        visited.put(startNode, true);

        int minutes = -1; // because at level 0 we already have the infection

        while (!q.isEmpty()) {
            int size = q.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                // spread infection to left child
                if (curr.left != null && !visited.containsKey(curr.left)) {
                    visited.put(curr.left, true);
                    q.offer(curr.left);
                }
                // spread infection to right child
                if (curr.right != null && !visited.containsKey(curr.right)) {
                    visited.put(curr.right, true);
                    q.offer(curr.right);
                }
                // spread infection to parent
                if (parentMap.containsKey(curr) && !visited.containsKey(parentMap.get(curr))) {
                    visited.put(parentMap.get(curr), true);
                    q.offer(parentMap.get(curr));
                }
            }
        }

        return minutes;
    }
}