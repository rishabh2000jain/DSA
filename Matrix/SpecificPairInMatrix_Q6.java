import java.io.PrintStream;
public class SpecificPairInMatrix_Q6 {
    public static PrintStream pt = System.out;
    ///Brakinging in small problem and keeping maximum value of i+1 and j+1 block in dp for i,j to solve the problem.

    public static void main(String[] args) {
        int arr[][] = {{9,2,3},{4,5,6},{7,8,1}};
        pt.println("ans => : "+findMaxValue(arr, 3));
    }
    public static int findMaxValue(int mat[][], int n) {
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[n][n];
        dp[n-1][n-1] = mat[n-1][n-1];
        for(int i= n-1;i>=0;--i){
            for(int j=n-1;j>=0;--j){
                if(i==n-1 && j== n-1)continue;
                int max=0;
                if(i==n-1){
                     max = Math.max(mat[i][j],dp[i][j+1]);
                }else if(j == n-1){
                    max = Math.max(mat[i][j],dp[i+1][j]);
                }else{
                    max = Math.max(mat[i][j],Math.max(dp[i+1][j],dp[i][j+1]));
                }
                dp[i][j] = max;
            }
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1;j++){
                int max = dp[i+1][j+1];
                int val = mat[i][j];
                int ans1 = max-val;
                ans = Math.max(ans1,ans);
            }
        }
        return ans;
    }
}

