class Solution {
    public int thirdMax(int[] nums) {
        TreeSet <Integer> set = new TreeSet<>();
        for(int x: nums){
            set.add(x);
        }
        if(set.size() < 3) return set.last();
        else{
            set.pollLast();
            set.pollLast();
            return set.last();
        }
    }
}