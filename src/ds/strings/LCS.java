package ds.strings;

public class LCS {

    public int withRecusrsion(char [] s1,char[] s2,int m,int n){
        if(m==0 || n==0){
            return 0;
        }
        if(s1[m]==s2[n]){
            return 1+withRecusrsion(s1,s2,m+1,n+1);
        }
        return Math.max(withRecusrsion(s1,s2,m+1,n),withRecusrsion(s1,s2,m,n+1));
    }

    public int withoutRecusrsion(char [] s1,char[] s2,int m,int n){
        int[][] output = new int[m][n];
        for(int i=0;i<=s1.length;i++){
            for(int j=0;j<=s2.length;j++){
               if(i==0 || j==0){
                   output[i][j]=0;
               }else{
                    if(s1[i-1]==s2[j-1]){
                        output[i][j]=1+output[i-1][j-1];
                    }else{
                        output[i][j]=Math.max(output[i-1][j],output[i][j-1]);
                    }

               }
            }
        }
        return output[m][n];
    }


    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;
        System.out.println(new LCS().withRecusrsion(X,Y,m,n));
        System.out.println(new LCS().withoutRecusrsion(X,Y,m,n));

    }
}
