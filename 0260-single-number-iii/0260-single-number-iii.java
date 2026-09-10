class Solution {
    public int[] singleNumber(int[] nums) {
        int n=nums.length;
        int[] arr=new int[2];
        int j=0;
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
           if(nums[i]==nums[i+1]){
            i++;
           }
           else{
            arr[j]=nums[i];
            j++;
           }
        }
        if(n>=2){
            if(nums[n-1]!=nums[n-2])arr[j]=nums[n-1];
        }
        
        return arr;
    }
}