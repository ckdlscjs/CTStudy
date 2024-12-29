public class Problem56 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = matrixAddition(arr1,arr2);
        return answer;
    }
    
    public int[][] matrixAddition(int[][] mat1, int[][] mat2){
        int n = mat1.length;
        int m = mat1[0].length;
        int[][] ret = new int[n][m];
        
        for(int i = 0;i<n;i++){
            for(int j =0;j<m;j++){
                ret[i][j] = mat1[i][j] + mat2[i][j];        
            }
        }
        return ret;
    }
}