class Solution {
    public int[] sortArray(int[] nums) {

       divide(nums,0,nums.length-1);
        
       
    return nums;
    }

    private static void conquer(int[] nums,int low,int mid, int high){
           int[] merged=new int[high-low+1];
           int left=low;
           int right=mid+1;
           int x=0;

           while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                merged[x]=nums[left];
                left++;
                x++;
            }
            else{
                merged[x]=nums[right];
                right++;
                x++;
            }
           }
           while(left<=mid){
             merged[x]=nums[left];
                left++;
                x++;
           }
           while(right<=high){
            merged[x]=nums[right];
                right++;
                x++;
           }
           for(int i=0;i<merged.length;i++){
            nums[low+i]=merged[i];
           }
       }

        private static void divide(int[] nums, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2 ;
        divide(nums, low, mid);  // left half
        divide(nums, mid + 1, high); // right half
        conquer(nums, low, mid, high);  // merging sorted halves
    }

    
    
}