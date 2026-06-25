class Solution {
    public int maxDistance(String moves) {
        int R=0;
        int L=0;
        int U=0;
        int D=0;
        int extra=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='U')U++;
            else if(moves.charAt(i)=='L')L++;
            else if(moves.charAt(i)=='R')R++;
            else if(moves.charAt(i)=='D')D++;
            else{
                extra++;
            }
        }
        return Math.abs(R-L)+Math.abs(U-D)+extra;
    }
}