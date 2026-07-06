class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0 ; i < prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

       
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses ; i++){
            for(int node : graph.get(i)){
                indegree[node]++;
            }
        }

        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }


        
        List<Integer> ts = new ArrayList<>();
        
        while(!q.isEmpty()){
            int node = q.remove();
            ts.add(node);

            for(int nbr : graph.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.add(nbr);
                }
            }

        }
        return ts.size() == numCourses ? true : false;
    }
}