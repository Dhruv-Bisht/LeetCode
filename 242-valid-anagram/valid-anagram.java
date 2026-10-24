class Solution {
    public boolean isAnagram(String s, String t) {

        // Method 1:- HashMap
        // if(s.length() != t.length()){
        //     return false;
        // }

        // HashMap<Character, Integer> map = new HashMap<>();

        // // Increment the value
        // for(int i=0; i<s.length(); i++){
        //     char character = s.charAt(i);
        //     map.put(character, map.getOrDefault(character, 0)+1);
        // }

        // // Decremenet the value
        // for(int i=0; i<t.length(); i++){
        //     char character = t.charAt(i);
        //     // subtracting the value
        //     map.put(character, map.getOrDefault(character, 0)-1);
        // }

        // // Traverse the HashMap
        // for(Map.Entry<Character, Integer> e: map.entrySet()){
        //     if(e.getValue() != 0){
        //         return false;
        //     }
        // }
        // return true;


        // Method 2:- Frequency Array
        int[] frequency = new int[26];

        // Increment Value
        
        // for(int i=0; i<s.length(); i++){
        //     char character = s.charAt(i);
        //     frequency[character - 'a']++;
        // }

        for(char character: s.toCharArray()){
            frequency[character - 'a']++;
        }

        // Decrement Value

        // for(int i=0; i<t.length(); i++){
        //     char character = t.charAt(i);
        //     frequency[character - 'a']--;
        // }

        for(char character: t.toCharArray()){
            frequency[character - 'a']--;
        }

        // traverse the array
        for(int i=0; i<26; i++){
            if(frequency[i] != 0){
                return false;
            }
        }
        return true;
    }
}