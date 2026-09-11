class Solution {
    public boolean winnerOfGame(String colors) {
        // int aliceMoves = 0;
        // int bobMoves = 0;
        // for(int i=1; i<colors.length()-1; i++){
        //     char current = colors.charAt(i);
        //     char left = colors.charAt(i-1);
        //     char right = colors.charAt(i+1);

        //     if(current == 'A' && left == 'A' && right == 'A'){
        //         aliceMoves ++;
        //     }
        //     else if(current == 'B' && left == 'B' && right == 'B'){
        //         bobMoves ++;
        //     }
        // }
        // return aliceMoves > bobMoves;

        char[] ch = colors.toCharArray();
        int n = ch.length;
        int alice = 0, bob = 0;
        for(int i=1; i<n-1; i++){
            if(ch[i] == ch[i+1] && ch[i] == ch[i-1]){
                if(ch[i] == 'A'){
                    alice++;
                }
                else{
                    bob++;
                }
            }
        }
        return alice>bob;
    }
}