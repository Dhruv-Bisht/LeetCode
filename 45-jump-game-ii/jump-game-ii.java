class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int[] dp = new int[n];

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0; i<n; i++){
            for(int j=1; j<=nums[i]; j++){
                if(i+j >= n){
                    break;
                }
                dp[i+j]=Math.min(dp[i+j], dp[i]+1);
            }
        }
        return dp[n-1];
    }
}