import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array
        
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            // Optimization: if the current number is positive, no combination can sum to 0
            if (nums[i] > 0) {
                break;
            }
            
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Step 2: Initialize two pointers
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum < 0) {
                    left++; // Sum is too small, move left pointer forward
                } else if (sum > 0) {
                    right--; // Sum is too large, move right pointer backward
                } else {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for the second element
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for the third element
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    // Move pointers inward after processing duplicates
                    left++;
                    right--;
                }
            }
        }
        
        return result;
    }
}
