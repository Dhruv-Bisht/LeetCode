class Solution {
    public int lengthLongestPath(String input) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0,0);
            int maxLen = 0;

            for(String name: input.split("\n")){
                String file = name.replace("\t","");
                int depth = name.length()-file.length();
                if(file.contains(".")){
                    // If it is a file.
                    // +1 because of sperator("/")
                    maxLen = Math.max(maxLen, map.get(depth)+file.length());
                }
                else{
                    map.put(depth+1,map.get(depth)+file.length()+1);
                }
            }

            return maxLen;
        }
    }