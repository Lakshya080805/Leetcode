class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return f(nums,goal)-f(nums,goal-1);
    }
    int f(int[] nums, int goal){
        int l=0;
        int r=0;
        int sum=0;
        int count=0;
        int n=nums.length;
        while(r<n){
            sum+=nums[r];
            while(sum>goal && l<=r){
                sum-=nums[l];
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
}