class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ls=new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        int top=0;
        int right=m-1;
        int bottom=n-1;
        int left=0;
        while(top<=bottom && left<=right){
            // right direction
            for(int i=left;i<=right;i++){
                ls.add(matrix[top][i]);
            }
            top++;
            //downward direction
            for(int i=top;i<=bottom;i++){
                ls.add(matrix[i][right]);
            }
            right--;
            // left direction
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    ls.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // upward direction
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    ls.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ls;
    }
}