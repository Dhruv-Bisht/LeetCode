class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, total = 0, res = 0;
        for(int i=0; i<n; i++){
            map.put(fruits[i],map.getOrDefault(fruits[i],0)+1);

            total += 1;

            while(map.size() > 2){
                int f = fruits[l];
                map.put(f, map.get(f)-1);
                total -=1;
                l+=1;
                if(map.get(f) == 0){
                    map.remove(f);
                }
            }

            res = Math.max(res,total);
        
        }

        return res;


    }
}