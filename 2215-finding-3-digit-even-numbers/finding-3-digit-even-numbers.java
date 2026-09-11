// class Solution {
//     public int[] findEvenNumbers(int[] digits) {
//         boolean[] vis = new boolean[100];
//         // int count = 0;
//         int[] result = new int[100];
//         int n = digits.length;
//         for(int i=0; i < n; i++){
//             if(digits[i] == 0){
//                 continue;
//             }
//             for(int j=0; j<n; j++){
//                 // if(j == i){
//                 //     continue;
//                 // }
//                 for(int k=0; k<n; k++){
//                     if(k == i || k == j || digits[k] %2 != 0){
//                         continue;
//                     }
//                     int x = digits[i]*100+digits[j]*10+digits[k];
//                     if(!vis[x]){
//                         vis[x] = true;
//                         // count++;
//                         result.append(x);
//                     }
//                 }
//             }
//         }
//         return result;
//     }
// }
class Solution {

    public int[] findEvenNumbers(int[] digits) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        // Count the number of occurrences of each number in the integer array
        for (int d : digits) {
            freq.put(d, freq.getOrDefault(d, 0) + 1);
        }
        // Enumerate all three-digit even numbers
        for (int i = 100; i < 1000; i += 2) {
            Map<Integer, Integer> freq1 = new HashMap<>();
            int num = i;
            // Count the frequency of each digit of the current even number
            while (num > 0) {
                int d = num % 10;
                freq1.put(d, freq1.getOrDefault(d, 0) + 1);
                num /= 10;
            }
            // Check if the conditions are met
            boolean isValid = true;
            for (Map.Entry<Integer, Integer> entry : freq1.entrySet()) {
                if (freq.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                res.add(i);
            }
        }
        // Convert to array
        int[] result = new int[res.size()];
        for (int j = 0; j < res.size(); j++) {
            result[j] = res.get(j);
        }
        return result;
    }
}