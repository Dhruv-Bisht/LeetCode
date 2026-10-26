class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int len = 0, maxLen = 0;
        int[] hashArray = new int[255];
        int left = 0, right = 0;
        for(int i=0; i<255; i++){
            hashArray[i] = -1;
        }
        while(right < n){
            if(hashArray[s.charAt(right)] != -1){
                // the number exists
                if(hashArray[s.charAt(right)] >= left){
                    // found duplicate. New left position
                    left = hashArray[s.charAt(right)] + 1;
                }
            }
            len = right - left + 1;
            maxLen = Math.max(len, maxLen);
            hashArray[s.charAt(right)] = right;
            right++;
        }
        return maxLen;
    }
}