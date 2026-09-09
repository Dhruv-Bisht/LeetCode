class Solution {
    public int matrixSum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;

        for(int i=0; i<m; i++){
            Arrays.sort(nums[i]);
        }
        int maxSum = 0;
        for(int j=n-1; j>=0; j--){
            int maxInt = 0;
            // int len = nums[j].length - 1;
            // maxSum += Math.max(maxInt,nums[j][len]);
            for(int i = 0; i < m; i++) {
                maxInt = Math.max(maxInt, nums[i][j]);
            }            
            maxSum += maxInt;
        }
        return maxSum;
    }
}