class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor=image[sr][sc];
        int ans[][]=image;
        int rowChange[]={-1,0,+1,0};
        int colChange[]={0,+1,0,-1};
        dfs(sr,sc,ans,image,initialColor,color,rowChange,colChange);
        return ans;
    }

    public void dfs(int sr,int sc,int[][] ans,int[][] image, int initialColor,int color,
    int rowChange[],int colChange[]){
        ans[sr][sc]=color;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int newRow=sr+rowChange[i];
            int newCol=sc+colChange[i];
            if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && image[newRow][newCol]==initialColor && ans[newRow][newCol]!=color){
                dfs(newRow,newCol,ans,image,initialColor,color,rowChange,colChange);
            }
        }
    }
}