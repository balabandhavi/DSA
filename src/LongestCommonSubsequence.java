public class LongestCommonSubsequence {

    private static String lcs(String a,String b){
        int m=a.length();
        int n=b.length();

        int[][] memo=new int[m+1][n+1];

        for(int i=0;i<=m;++i){
            for(int j=0;j<=n;++j){

                if(i==0 || j==0){
                    memo[i][j]=0;
                    continue;
                }

                if(a.charAt(i-1)==b.charAt(j-1)) memo[i][j]=1+memo[i-1][j-1];

                else memo[i][j]=Math.max(memo[i-1][j],memo[i][j-1]);
            }
        }

        System.out.println("Length of the longest common subsequence is : "+memo[m][n]);

        StringBuilder s=new StringBuilder();

        int i=m,j=n;

        while(i>0 && j>0){

            if(a.charAt(i-1)==b.charAt(j-1)){
                s.append(a.charAt(i-1));
                --i;
                --j;
            }else if(memo[i-1][j]>memo[i][j-1]) --i;
            else --j;
        }

        s.reverse();

        return s.toString();
    }

    private static String shortestCommonSupersequence(String a,String b){

        //refer to the shortestcommonsupersequence notes of tuf(take u forward)

        int m=a.length();
        int n=b.length();

        int[][] memo=new int[m+1][n+1];

        for(int i=0;i<=m;++i){
            for(int j=0;j<=n;++j){

                if(i==0 || j==0){
                    memo[i][j]=0;
                    continue;
                }

                if(a.charAt(i-1)==b.charAt(j-1)) memo[i][j]=1+memo[i-1][j-1];

                else memo[i][j]=Math.max(memo[i-1][j],memo[i][j-1]);
            }
        }

        System.out.println("The length of the shortest common superseuence of "+a+" "+b+" is "+(m+n-memo[m][n]));

        StringBuilder s=new StringBuilder();

        int i=m,j=n;

        while(i>0 && j>0){

            if(a.charAt(i-1)==b.charAt(j-1)){
                s.append(a.charAt(i-1));
                --i;
                --j;
            }
            else if(memo[i-1][j]>memo[i][j-1]){
                s.append(a.charAt(i-1));
                --i;
            }else{
                s.append(b.charAt(j-1));
                --j;
            }
        }

        while(i>0){
            s.append(a.charAt(i-1));
            --i;
        }

        while(j>0){
            s.append(b.charAt(j-1));
            --j;
        }

        s.reverse();

        return s.toString();
    }

    public static void main(String[] args) {

        String a="Naruto";
        String b="Nagato";

        System.out.println(lcs(a,b));

        System.out.println(shortestCommonSupersequence(a,b));
    }
}
