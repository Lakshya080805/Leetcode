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
    public boolean isSymmetric(TreeNode root) {
        return root==null || symmetric(root.left,root.right);
    }
    public boolean symmetric(TreeNode left, TreeNode right){
        if(right==null || left==null){
            return left==right;
        }
        if(right.val!=left.val) return false;
        return symmetric(left.left,right.right) && symmetric(left.right,right.left);
    }
}