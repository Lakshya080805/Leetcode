import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        
        // Max heap: compare by value descending
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );
        
        for (int i = 0; i < n; i++) {
            // Add current element with index
            pq.offer(new int[]{nums[i], i});
            
            // Remove elements outside window
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            
            // Window starts forming when i >= k - 1
            if (i >= k - 1) {
                result[i - k + 1] = pq.peek()[0];
            }
        }
        
        return result;
    }
}
