class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Increment the value
        for(int i=0; i<s.length(); i++){
            char character = s.charAt(i);
            map.put(character, map.getOrDefault(character, 0)+1);
        }

        // Decremenet the value
        for(int i=0; i<t.length(); i++){
            char character = t.charAt(i);
            // subtracting the value
            map.put(character, map.getOrDefault(character, 0)-1);
        }

        // Traverse the HashMap
        for(Map.Entry<Character, Integer> e: map.entrySet()){
            if(e.getValue() != 0){
                return false;
            }
        }
        return true;
    }
}