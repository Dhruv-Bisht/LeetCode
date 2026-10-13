class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0; // Left boundary of the sliding window

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already in the map and within the current window
            if (map.containsKey(currentChar)) {
                // Move the left pointer past the last seen index of this character
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // Update or add the character's most recent index
            map.put(currentChar, right);

            // Calculate the current window size and update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}