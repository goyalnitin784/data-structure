package ds.dp;

import java.util.Arrays;

public class LongestPathInAMatrix {
    public static void main(String[] args)
    {
        int mat[][] = {
                { 1, 2, 3, 4 },
                { 2, 2, 3, 4 },
                { 3, 2, 3, 4 },
                { 4, 5, 6, 7 },
        };
        int n = 4, m = 4;
        System.out.println(wrapper(mat, m, n));

    }
    static int wrapper(int mat[][], int m, int n)
    {
        int dp[][] = new int[10][10];
        for(int i = 0; i < 4; i++)
            Arrays.fill(dp[i],-1);
        return LIP(dp, mat, n, m, 0, 0);
    }
    static int LIP(int[][] dp,int[][] matrix,int m,int n,int x,int y){

        if(dp[x][y]==-1){
            if(x==m-1 && y==n-1){
                dp[x][y]=1;
                return 1;
            }

            if(x+1<m && matrix[x][y]<= matrix[x+1][y] ){
                dp[x][y]=1+LIP(dp,matrix,m,n,x+1,y);
            }

            if(y+1<n && matrix[x][y]<= matrix[x][y+1]){
                dp[x][y]=Math.max(dp[x][y],1+LIP(dp,matrix,m,n,x,y+1));
            }
        }
        return dp[x][y];
    }
}
