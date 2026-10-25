class Solution {
    public int thirdMax(int[] nums) {
        // Method 1:- Using Set

        // TreeSet <Integer> set = new TreeSet<>();
        // for(int x: nums){
        //     set.add(x);
        // }
        // if(set.size() < 3) return set.last();
        // else{
        //     set.pollLast();
        //     set.pollLast();
        //     return set.last();
        // }


        // Method 2:- 
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            if(nums[i] > firstMax){
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            }
            else if(nums[i] < firstMax && nums[i] > secondMax){
                thirdMax = secondMax;
                secondMax = nums[i];
            }
            else if(nums[i] < secondMax && nums[i] > thirdMax){
                thirdMax = nums[i];
            }
            else{
                continue;
            }
        }
        if(thirdMax == Long.MIN_VALUE){
            return (int) firstMax;
        }
        return (int) thirdMax;
    }
}