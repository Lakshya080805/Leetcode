class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return  f(nums,k)-f(nums,k-1);
    }
    int f(int[]  nums, int k){
        int l=0;
        int r=0;
        int count=0;
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(r<n){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>k && l<=r){
                map.put(nums[l],map.getOrDefault(nums[l],0)-1);
                
                if(map.get(nums[l])==0)map.remove(nums[l]);
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
}