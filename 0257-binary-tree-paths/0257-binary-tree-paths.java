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

    static void getAllPaths(TreeNode root, StringBuilder curr, List<String> ans) {
        if (root == null) return;

        int len = curr.length();

        if (len != 0) {
            curr.append("->");
        }
        curr.append(root.val);

        if (root.left == null && root.right == null) {
            ans.add(curr.toString());
        } else {
            getAllPaths(root.left, curr, ans);
            getAllPaths(root.right, curr, ans);
        }

        // Backtrack
        curr.setLength(len);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        getAllPaths(root, new StringBuilder(), ans);
        return ans;
    }
}