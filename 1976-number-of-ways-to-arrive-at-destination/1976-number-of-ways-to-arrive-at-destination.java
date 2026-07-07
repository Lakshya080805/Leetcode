class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }

        // Create a priority queue (min heap) for Dijkstra's algorithm
        long[] dist = new long[n];
        long[] ways=new long[n];
Arrays.fill(dist, Long.MAX_VALUE);

PriorityQueue<long[]> pq =
    new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

dist[0] = 0;
ways[0]=1;
pq.offer(new long[]{0,0});
int mod = (int)(1e9 + 7);
while(!pq.isEmpty()){

    long[] curr = pq.poll();
    long dis = curr[0];
    int node = (int)curr[1];

    if(dis > dist[node]) continue;

    for(int[] nei : adj.get(node)){

        int adjNode = nei[0];
        int wt = nei[1];

        if(dis + wt < dist[adjNode]){

            dist[adjNode] = dis + wt;
            ways[adjNode] = ways[node];
            pq.offer(new long[]{dist[adjNode], adjNode});

        }
        else if(dis + wt == dist[adjNode]){

            ways[adjNode] = (ways[adjNode] + ways[node]) % mod;

        }
    }
}
return (int)(ways[n-1]%mod);
    }
}