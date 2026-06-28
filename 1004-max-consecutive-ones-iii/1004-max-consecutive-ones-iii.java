class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0;
        int r=0;
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        int count=0;
        while(r<n){
            if(nums[r]==0)count++;
            while(count>k){
                if(nums[l]==0)count--;
                l++;
            }
            max=Math.max(r-l+1,max);
            r++;
        }
        return max;
    }
}