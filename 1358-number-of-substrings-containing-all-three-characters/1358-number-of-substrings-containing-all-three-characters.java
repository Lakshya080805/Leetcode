class Solution {
    public int numberOfSubstrings(String s) {
        int left=0;
        int right=0;
        
        // HashSet<Character> set=new HashSet<>();

        int[] freq = new int[3];
        int total=0;
        while(right<s.length()){
            // set.add(s.charAt(right));
            // while(set.size()==3){
            //     total+=s.length()-right;

            //     set.remove(s.charAt(left));
            //     left++;
            // }
            // right++;

             
            freq[s.charAt(right) - 'a']++;

            
            while (hasAllChars(freq)) {
               
                total +=s.length()  - right;

                
                
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return total;
    }

     private boolean hasAllChars(int[] freq) {
        
        return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
    }
}