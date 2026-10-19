class Solution {
    public int oddEvenJumps(int[] arr) {
        int good_starting_index_count = 1;
        int n = arr.length;

        // storing the value as True/False 
        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];

        // coz we are stating from last.
        higher[n-1] = true;
        lower[n-1] = true;

        TreeMap<Integer, Integer> treeMap = new TreeMap();
        treeMap.put(arr[n-1],n-1);
        
        for(int i=n-2; i>=0; i--){
            // cielingEntry method return higher or equal value
            Map.Entry higher_key_val_pair = treeMap.ceilingEntry(arr[i]);

            // floorEntry method returns lower or equal value
            Map.Entry lower_key_val_pair = treeMap.floorEntry(arr[i]);

            // return null if No such values exits.
            if(higher_key_val_pair != null){
                higher[i] = lower[(int)higher_key_val_pair.getValue()];
            }

            if(lower_key_val_pair != null){
                lower[i] = higher[(int)lower_key_val_pair.getValue()];
            }
            if(higher[i]){
                good_starting_index_count++;
            }
            treeMap.put(arr[i], i);
        }
        return good_starting_index_count;
    }
}