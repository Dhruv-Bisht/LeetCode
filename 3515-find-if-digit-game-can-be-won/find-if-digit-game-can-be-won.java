class Solution {
    public boolean canAliceWin(int[] nums) {
        int oneDigitSum = 0, twoDigitSum = 0;
        if(nums.length == 1) {return true;};
        for(int num:nums){
            if(num >=10){twoDigitSum += num;};
            if(num < 10){oneDigitSum += num;};
        }
        return !(oneDigitSum == twoDigitSum);
    }
}