class Solution {
    public boolean canEat(int[] piles,int hours,int h){
        int ans=0;
     for(int i=0;i<piles.length;i++){
         ans+=Math.ceil((double)piles[i]/hours);
     }
     if(ans<=h)return true;
     return false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            high=Math.max(high,piles[i]);
        }
        while(low<high){
            int mid=low+(high-low)/2;
            if(canEat(piles,mid,h)){
                high=mid;
            }
            else {
                low=mid+1;
            }
        }
        return low;
    }
}