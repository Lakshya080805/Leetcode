class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())return "";
        Map<Character,Integer> mppT=new HashMap<>();
        Map<Character,Integer> mppS=new HashMap<>();
        for(char ch:t.toCharArray()){
            mppT.put(ch,mppT.getOrDefault(ch,0)+1);
        }
        int left=0;
        int right=0;
        int formed=0;
        int require=mppT.size();
        int startIdx=0;
        int minLen=Integer.MAX_VALUE;
        while(right<s.length()){
            char ch=s.charAt(right);
            mppS.put(ch,mppS.getOrDefault(ch,0)+1);
            if(mppT.containsKey(ch) && mppS.get(ch).intValue()==mppT.get(ch).intValue()){
                formed++;
            }
            while(formed==require){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    startIdx=left;
                }

                char chLeft=s.charAt(left);
                mppS.put(chLeft, mppS.get(chLeft) - 1);
                if (mppT.containsKey(chLeft) && mppS.get(chLeft) < mppT.get(chLeft)) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        if(minLen==Integer.MAX_VALUE)return "";
        else{
            return s.substring(startIdx,startIdx+minLen);
        }
    }
}