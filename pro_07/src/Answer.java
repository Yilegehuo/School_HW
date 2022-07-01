public class Answer {
    public static boolean isMatch(String s, String p) {
        //动态规划：
        //dp[i][j]表示s的第i个字符和p的第j个字符能否匹配
        int slen=s.length();
        int plen=p.length();
        boolean dp[][]=new boolean[slen+1][plen+1];
        dp[0][0]=true;
        for (int i=1;i<=p.length();i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i]=true;
            }else {
                break;
            }
        }
        for (int i=1;i<=s.length();i++){
            for (int j=1;j<=p.length();j++){
                if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-1]||dp[i-1][j];

                }else if (p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(j-1)==s.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
            }
        }
        return dp[slen][plen];
    }
}
