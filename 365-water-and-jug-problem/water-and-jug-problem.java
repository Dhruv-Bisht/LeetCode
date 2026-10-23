class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if(target > x+y){
            return false;
        }    
        return target % gcd(x,y) == 0;
    }

    private int gcd(int x, int y){
        if( y == 0){
            return x;
        }

        return gcd(y,x%y);
    }
}