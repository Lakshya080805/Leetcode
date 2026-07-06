class Pair{
    int row;
    int col;
    int time;
    Pair(int _row,int _col,int _time){
        this.row=_row;
        this.col=_col;
        this.time=_time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        Queue<Pair> q=new LinkedList<>();

        int[][] vis=new int[n][m];
        // int countFresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
                // if(grid[i][j]==1)countFresh++;
            }
        }

        int time=0;
        int rowChange[]={-1,0,+1,0};
        int colChange[]={0,1,0,-1};

        int count=0;
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().time;
            time=Math.max(time,t);
            q.remove();
            for(int i=0;i<4;i++){
                int newRow=r+rowChange[i];
                int newCol=c+colChange[i];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && vis[newRow][newCol]!=2 && grid[newRow][newCol]==1){
                    q.add(new Pair(newRow,newCol,time+1));
                    vis[newRow][newCol]=2;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]!=2 && grid[i][j]==1){
                    return -1;
                }
            }
        }

        return time;
    }
}