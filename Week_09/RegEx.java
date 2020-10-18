public class RegEx {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        int i = 1;
        while (i <= p.length() && p.charAt(i - 1) == '*'){
            dp[0][i] = true;
            i++;
        }

        for (int j = 1; j <= m; ++j){
            for (int k = 1; k <= n; ++k){
                if (s.charAt(j - 1) == p.charAt(k - 1) || p.charAt(k - 1) == '?'){
                    dp[j][k] = dp[j - 1][k - 1];
                }
                else if (p.charAt(k - 1) == '*'){
                    dp[j][k] = dp[j][k - 1] || dp[j - 1][k];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new RegEx().isMatch("adceb", "*"));
    }


}
