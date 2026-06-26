class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int element=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                count=1;
                element=nums[i];
            }
            else if(element==nums[i]){
                count++;
            }
            else{
                count--;
            }
        }
        int count1=0;
        for(int i=0;i<nums.length;i++){
            if(element==nums[i]){
                count1++;
            }
        }
        int ans=0;
        if(count1>nums.length/2){
             ans=element;
        }
        else{
            ans=-1;
        }
        return ans;
        
    }
}