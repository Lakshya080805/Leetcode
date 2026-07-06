class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
               if(isConnected[i][j]==1 && i!=j){
                adj.get(i).add(j);
                adj.get(j).add(i);
               } 
            }
        }

        boolean visted[]=new boolean[V];
        int count=0;
        for(int i=0;i<V;i++){
            if(!visted[i]){
                count++;
                dfs(i,adj,visted);
            }
        }
        return count;
    }

    public static void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean visited[]){
        visited[node]=true;
        for(int i:adj.get(node)){
            if(!visited[i]){
                dfs(i,adj,visited);            }
        }
    }
}