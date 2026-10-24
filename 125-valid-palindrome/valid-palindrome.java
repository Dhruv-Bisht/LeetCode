class Solution {
    public boolean isPalindrome(String s) {
        String regex = "[\\p{P}\\p{S}\\s\\p{Z}]+";
        String newString = s.replaceAll(regex,"").toLowerCase();
        int low = 0, high = newString.length()-1;
        while(low < high){
            if(newString.charAt(low) != newString.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}