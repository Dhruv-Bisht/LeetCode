class Solution {
    public int arraySign(int[] nums) {
        int sign = 1; // Start assuming the product is positive
        
        for (int num : nums) {
            if (num == 0) {
                return 0; // Any number multiplied by 0 is 0, so exit early
            }
            if (num < 0) {
                sign = -sign; // A negative number flips the sign
            }
            // If num > 0, the sign doesn't change, so we do nothing
        }
        
        return sign;
    }
}