class Solution {
      public static int countStudents(int[] nums,int mid){
        int students=1;
        long pagesCount=0;
        for(int i=0;i<nums.length;i++){
            if(pagesCount+nums[i]>mid){
                students++;
                pagesCount=nums[i];
            }
            else{
                pagesCount+=nums[i];
            }
        }
        return students;
    }
    public int splitArray(int[] nums, int k) {
         int n=nums.length;
        if(n<k){
            return -1;
        }
      
        int low=0;
        int sum=0;
        
        int ans=-1;
        for(int i=0;i<n;i++){
            low=Math.max(low,nums[i]);
            sum+=nums[i];
        }
        
        int high=sum;
        while(low<=high){
            int mid=(low+high)/2;
            int students=countStudents(nums,mid);
            if(students>k){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        
        return low;
    }
}