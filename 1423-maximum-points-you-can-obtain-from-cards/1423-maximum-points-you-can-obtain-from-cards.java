class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        int max=sum;
        int i=k-1;
        int j=n-1;
        while(i>=0 && j>=i){
            sum+=cardPoints[j];
            sum-=cardPoints[i];
            i--;
            j--;
            max=Math.max(max,sum);
        }
        return max;
    }
}