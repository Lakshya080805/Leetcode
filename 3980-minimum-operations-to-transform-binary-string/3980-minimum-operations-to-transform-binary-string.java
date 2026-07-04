class Solution {
    public int minOperations(String s1, String s2) {
            int n=s1.length();
        if(n==1){
            char c1=s1.charAt(0);
            char c2=s2.charAt(0);
            if(c1=='0' && c2=='1')return 1;
            if(c1==c2)return 0;
            return -1;
        }

        int costa=0;
            int costb=0;
        int pair=0;
        int len=0;
        for(int i=0;i<n;i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            boolean isa=(c1=='1' && c2=='0');
                boolean isb=(c1=='0' && c2=='1');

            if(isb){
                costb++;
            }
            if(isa){
                costa++;
                len++;
                if(len==2){
                    pair++;
                    len=0;
                }
            }
            else{
                len=0;
            }
        }

        return costb+2*costa-3*pair;
    }
}