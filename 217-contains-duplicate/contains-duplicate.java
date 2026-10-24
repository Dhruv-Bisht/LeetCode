class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet <Integer> set = new HashSet<>();

        for(int num:nums){
            if(set.add(num) == false){
                return true;
            }
        }
        return false;
    }
}