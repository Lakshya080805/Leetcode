class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> mpp=new HashMap<>();
        int left=0;
        int right=0;
        int maxLen=0;
        int maxFreq=0;
        while(right<s.length()){
            char ch=s.charAt(right);
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
            maxFreq=Math.max(maxFreq,mpp.get(ch));
            if((right-left+1)-maxFreq>k){
                mpp.put(s.charAt(left),mpp.get(s.charAt(left))-1);
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
            right++;
            
        }
        return maxLen;
    }
}