package ds.dp;
/*
* Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

Insert
Remove
Replace
All of the above operations are of equal cost.
Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.


* */
public class EditDistance {
    int min(int x, int y, int z){
        if (x <= y && x <= z) return x;
        if (y <= x && y <= z) return y;
        else return z;
    }

    int calculateDisctance(char[] a,char[] b,int m,int n){
        if(m==0){
            return n;
        }
        if(n==0){
            return  m;
        }
        if (a[m-1] == b[n-1])
            return calculateDisctance(a, b, m-1, n-1);

        return min(calculateDisctance(a,b,m-1,n-1),calculateDisctance(a,b,m-1,n),calculateDisctance(a,b,m,n-1));
    }

    int calculateDisctanceWithDP(char[] a,char[] b,int m,int n){
        int[][]  dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0){
                    dp[i][j]=j;
                }
                if(j==0){
                    dp[i][j]=i;
                }
                if(a[i]==b[j]){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]= 1+ min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m+1][n+1];
    }
    public static void main(String[] args) {
        String a = "nitin";
        String b = "niti";
        System.out.println(new EditDistance().calculateDisctance(a.toCharArray(),b.toCharArray(),a.length(),b.length()));
    }
}
