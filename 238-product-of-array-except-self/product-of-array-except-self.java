class Solution {
    public int[] productExceptSelf(int[] nums) {
        int right = 1;
        int left = 1;
        int[] result = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            result[i] = left;
            left *= nums[i];
        } 

        for(int i=nums.length-1; i>=0; i--){
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }
}