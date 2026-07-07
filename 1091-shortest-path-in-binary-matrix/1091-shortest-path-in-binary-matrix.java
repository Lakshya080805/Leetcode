class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
         
         
        int n = grid.length;
        int m = grid[0].length;
        
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)return -1;
        if(n==1)return 1;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = 1;

        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1,0,0});  // Push source cell with distance 0

        // Define the possible directions (up, right, down, left)
        

        // Start BFS traversal
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int dis = current[0];
            int r = current[1];
            int c = current[2];
            
            for (int dr = -1; dr <= 1; dr++) {
    for (int dc = -1; dc <= 1; dc++) {
        if (dr == 0 && dc == 0) continue; // Skip the current cell

        int newr = r + dr;
        int newc = c + dc;
if (newr >= 0 && newr < n && newc >= 0 && newc < m && grid[newr][newc] == 0 && dis + 1 < dist[newr][newc]) {
                    dist[newr][newc] = dis + 1;  // Update the distance

                    // If destination is reached, return the distance
                    if (newr == n-1 && newc == m-1)
                        return dis + 1;

                    // Add the new cell to the queue for further processing
                    q.offer(new int[]{dis + 1, newr, newc});
                }
        
    }
 }
            // Check all 4 adjacent directions
       
        }
        // If no path is found from source to destination
        return -1;
    }
}