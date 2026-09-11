class Solution {
    public int[] evenOddBit(int n) {
        char[] binaryChar = Integer.toBinaryString(n).toCharArray();
        int evenCount = 0;
        int oddCount = 0;
        int bitIndex = 0;
        for(int i=binaryChar.length - 1; i>=0;i--){
            int num = binaryChar[i]-'0';
            if(num == 1){
                if(bitIndex % 2 == 0){
                    evenCount ++;
                }else{
                    oddCount++;
                }
            }
            bitIndex ++;
        }   
        return new int[] {evenCount, oddCount}; 
    }
}