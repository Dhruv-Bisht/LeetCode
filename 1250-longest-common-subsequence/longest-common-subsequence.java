class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        // DP table where dp[i][j] stores the LCS of text1(0...i-1) and text2(0...j-1)
        int[][] dp = new int[m + 1][n + 1];
        
        // Build the table from the bottom up
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Fix 1 & 2: Use .charAt() and add 1 if characters match
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Fix 3: Take the max of skipping a character from either string
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // The bottom-right corner holds the final answer
        return dp[m][n];
    }
}
