class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        //  if (nums.length < 4) {
        //     return ans; // return empty list if there are fewer than 4 numbers
        // }
        //  if (nums[0] * 4 > target || nums[nums.length - 1] * 4 < target) {
        //     return ans; // if the sum of all numbers is out of range for target
        // }
         for(int i=0;i<nums.length-3;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int left=j+1;
                int right=nums.length-1;
                while(left<right){
                long sum=(long)nums[i]+nums[j]+nums[left]+nums[right];
                if(sum==target){
                    ans.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));

                    while(left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(sum>target){
                    right--;
                }
                else{
                    left++;
                }
            }
            }
         }
         return ans;
    }
}