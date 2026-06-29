
class Meeting {
    int start, end;
    
    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Meeting[] meetings = new Meeting[intervals.length + 1];

        for (int i = 0; i < intervals.length; i++) {
            meetings[i] = new Meeting(intervals[i][0], intervals[i][1]);
        }

        meetings[intervals.length] = new Meeting(newInterval[0], newInterval[1]);

        Arrays.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));

        List<int[]> ans = new ArrayList<>();

        int start = meetings[0].start;
        int end = meetings[0].end;

        for (int i = 1; i < meetings.length; i++) {

            if (meetings[i].start <= end) {
                end = Math.max(end, meetings[i].end);
            } else {
                ans.add(new int[]{start, end});
                start = meetings[i].start;
                end = meetings[i].end;
            }
        }

        ans.add(new int[]{start, end});

        return ans.toArray(new int[ans.size()][]);
    }
}