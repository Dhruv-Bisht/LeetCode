class Solution {
    public int rob(int[] nums) {
        int amount = 0;
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int prev2 = 0; // Max money up to two houses ago
        int prev1 = 0; // Max money up to one house ago

        for(int num:nums){
            int current = Math.max(num+prev2, prev1);
            prev2 = prev1;
            prev1 = current;
        }    

        return prev1;
    }
}