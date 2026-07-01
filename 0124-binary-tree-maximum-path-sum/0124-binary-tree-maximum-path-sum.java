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
    public int maxPathSum(TreeNode root) {
        int[] maxVal=new int[1];
        maxVal[0]=Integer.MIN_VALUE;
        sum(root,maxVal);
        return maxVal[0];
    }

    public int sum(TreeNode root, int[] maxVal){
        if(root==null) return 0;
        int leftSum=Math.max(0,sum(root.left,maxVal));
        int rightSum=Math.max(0,sum(root.right,maxVal));

        maxVal[0]=Math.max(maxVal[0],leftSum+rightSum+root.val);

        return Math.max(leftSum,rightSum) +root.val;
    }

}