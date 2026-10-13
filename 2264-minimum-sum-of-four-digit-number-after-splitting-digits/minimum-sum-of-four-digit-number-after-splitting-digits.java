// class Solution {
//     public int minimumSum(int num) {
//         int[] digits = new int[4];

//         for(int i=0; i<4; i++){
//             digits[i]=num%10;
//             num = num/10;
//         }

//         Arrays.sort(digits);

//         int num1 = digits[0]*10+digits[2];
//         int num2 = digits[1]*10+digits[3];

//         return num1 + num2;
//     }
// }

class Solution {
    public int minimumSum(int num) {
      int min1 = 10;
      int min2 = 10;
      int sum=0;
      while(num!=0){
        int x =num%10;
        sum+=x;
        if(x<min1){
            min2=min1;
            min1=x;
        }
        else if(x<min2){
            min2=x;
        }
        num/=10;
      }
      int y=min1+min2;
      int z=sum-y;
      return 10*y+z; 
    }
}
