class Solution {
    public int findNumbers(int[] nums) {
        // In Java:- when number is Log10(num) gives us how many times a number is divided before becoming 0;
        int result = 0;
        for(int num:nums){
            int digit = (int) Math.log10(num) + 1;
            if(digit %2 == 0){
                result++;
            }
        }
        return result;
        // int count = 0;
        // int result = 0;
        // int len = nums.length;
        // for(int i=0; i<len; i++){
        //     int n = nums[i];
        //     int count = 0;
        //     while(n>0)
        //     {   
        //         n = n / 10;
        //         count ++;
        //     }
        //     if(count % 2 == 0){
        //         result ++;
        //     }
        // }
        // return result;
    }
}