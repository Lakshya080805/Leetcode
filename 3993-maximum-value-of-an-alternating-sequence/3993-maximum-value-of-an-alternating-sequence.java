class Solution {
    public long maximumValue(int n, int s, int m) {
        // long[] arr1=new long[n];
        // long[] arr2=new long[n];
        // arr1[0]=s;
        // arr2[0]=s;
        // long ans=arr1[0];
        // for(int i=1;i<n;i++){
        //     if(i%2==0){
        //         arr1[i]=arr1[i-1]-1;
        //     }
        //     else{
        //         arr1[i]=arr1[i-1]+m;
        //     }
        //     ans=Math.max(ans,arr1[i]);
        // }
        // for(int i=1;i<n;i++){
        //     if(i%2==0){
        //         arr2[i]=arr2[i-1]+m;
        //     }
        //     else{
        //         arr2[i]=arr2[i-1]-1;
        //     }
        //     ans=Math.max(ans,arr2[i]);
        // }
        // return ans;


        if(n==1)return s;

        long up=n/2;
        long bestup=s+up*m-(up-1);

        long down=(n-1)/2;
        long bestdown=s+down*(m-1);

        return Math.max(bestup,bestdown);
    }
}