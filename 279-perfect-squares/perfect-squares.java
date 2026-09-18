class Solution {
    public int numSquares(int n) {
        // dp[i] will store the minimum number of perfect squares for sum i
        int[] dp = new int[n + 1];
        
        // Initialize the array with a maximum possible value (or i itself, since 1+1+1... is worst case)
        for (int i = 1; i <= n; i++) {
            dp[i] = i; 
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        return dp[n];
    }
}
