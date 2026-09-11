class Solution {
    public boolean winnerOfGame(String colors) {
        int aliceMoves = 0;
        int bobMoves = 0;
        for(int i=1; i<colors.length()-1; i++){
            char current = colors.charAt(i);
            char left = colors.charAt(i-1);
            char right = colors.charAt(i+1);

            if(current == 'A' && left == 'A' && right == 'A'){
                aliceMoves ++;
            }
            else if(current == 'B' && left == 'B' && right == 'B'){
                bobMoves ++;
            }
        }
        return aliceMoves > bobMoves;
    }
}