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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> mpp=new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            mpp.put(inorder[i],i);
        }

        TreeNode root=buildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,mpp);

        return root;
    }

     public TreeNode buildTree(int[] postorder,int postStart,int postEnd,int[] inorder,int inStart,int inEnd,Map<Integer,Integer> mpp){
        if(postStart>postEnd || inStart>inEnd) return null;

        TreeNode root=new TreeNode(postorder[postEnd]);

        int idxRoot=mpp.get(root.val);

        int numsLeft=idxRoot-inStart;

        root.left=buildTree(postorder,postStart,postStart+numsLeft-1,inorder,inStart,idxRoot-1,mpp);

        root.right=buildTree(postorder,postStart+numsLeft,postEnd-1,inorder,idxRoot+1,inEnd,mpp);

        return root;
    }
}