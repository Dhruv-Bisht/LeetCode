class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap<String, ArrayList<String>> map = new HashMap();
        HashMap<String, List<String>> map = new HashMap();
        
        for(String name: strs){
            char[] charArray = name.toCharArray();
            Arrays.sort(charArray);
            String sortName = new String(charArray);

            map.computeIfAbsent(sortName, 
                k -> new ArrayList<>()
            ).add(name);
        }

        return new ArrayList<>(map.values());
    }
}