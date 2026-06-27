class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         int j=0;
        int i=matrix.length-1;
        while(i>=0 && j<matrix[0].length){
            if(target<matrix[i][j]){
                i--;
            }
            else if(target>matrix[i][j]){
                j++;
            }
            else{
                return true;
            }
        }
        return false;
    }
}