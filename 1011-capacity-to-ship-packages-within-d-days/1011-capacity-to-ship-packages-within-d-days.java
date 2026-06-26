class Solution {
    public int daysNeeded(int[] weights,int mid){
        int days=1;
        int currLoad=0;
        for(int w:weights){
            if(currLoad+w>mid){
                days++;
                currLoad=w;
            }
            else{
                currLoad+=w;
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int num:weights){
            low=Math.max(low,num);
            high+=num;
        }
        int ans=-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(daysNeeded(weights,mid)<=days){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}