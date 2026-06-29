class Meeting {
    int start, end;
    
    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
       
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0;
        int prevEnd = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) { 
                count++;
            } else {
                prevEnd = intervals[i][1]; 
            }
        }
        
        return count;
    }
}


// String s="aditya";
// int[] arr=new int[256];
// for(int i=0;i<s.length();i++){
//     char c=s.charAt(i);
//     arr[c]++''
// }