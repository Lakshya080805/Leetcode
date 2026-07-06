class Node {
    int first;
    int second;
    int third;

    Node(int _first, int _second, int _third) {
        first = _first;
        second = _second;
        third = _third;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int vis[][]=new int[n][m];
        int ans[][]=new int[n][m];

        Queue<Node> q=new LinkedList<>();

        for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
            if(mat[i][j]==0){
                q.add(new Node(i,j,0));
                vis[i][j]=1;
            }
            
            
          }
        }

        int rowChange[]={-1,0,+1,0};
        int colChange[]={0,+1,0,-1};

       while(!q.isEmpty()){
        int row=q.peek().first;
        int col=q.peek().second;
        int steps=q.peek().third;
        q.remove();
        ans[row][col]=steps;
        for(int i=0;i<4;i++){
            int newRow=row+rowChange[i];
            int newCol=col+colChange[i];

            if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && vis[newRow][newCol]==0){
                vis[newRow][newCol]=1;
                q.add(new Node(newRow,newCol,steps+1));
            }
        }

       }
       return ans;
    }
}