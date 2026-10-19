// // /**
// //  * // This is the Master's API interface.
// //  * // You should not implement it, or speculate about its implementation
// //  * interface Master {
// //  *     public int guess(String word) {}
// //  * }
// //  */
// class Solution {
//     private int matchCount(String a, String b){
//         int matches = 0;

//         for(int i=0; i<6; i++){
//             if(a.charAt(i) == b.charAt(i)){
//                 matches ++;
//             }
//         }
//         return matches;
//     }



//     public void findSecretWord(String[] words, Master master) {
        
//         List<String> candidates = new ArrayList<>(
//             Arrays.asList(words)
//         );

//         for(int turn = 0; turn < 10 && !candidates.isEmpty(); turn++){
//             String bestGuess = candidates.get(0);
//             int bestWorstCase = Integer.MAX_VALUE;

//             // find the guess with the smallest largest bucket
//             for(String guess: candidates){
//                 int[] buckets = new int[7];

//                 for(String word: candidates){
//                     int score = matchCount(guess, word);
//                     buckets[score]++;
//                 }

//                 int worstCase = 0;

//                 for(int count : buckets){
//                     worstCase = Math.max(worstCase, count);
//                 }

//                 if(worstCase < bestWorstCase){
//                     bestWorstCase = worstCase;
//                     bestGuess = guess;
//                 }
//             }

//             // Make one real guess
//             int feedback = master.guess(bestGuess);
//             if(feedback == 6){
//                 return;
//             }

//             // Keep only words consistent with the feedback
//             List<String> nextCandidates = new ArrayList<>();

//             for(String word:candidates){
//                 if(matchCount(bestGuess, word) == feedback){
//                     nextCandidates.add(word);
//                 }
//             }
//             candidates = nextCandidates;
//         }
        
//     }
// }


class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        Random random = new Random();
        for(int i = 0, matches = 0; i < 10 && matches != 6; i ++){
            String guess = wordlist[random.nextInt(wordlist.length)];
            matches = master.guess(guess);
            List<String> candidates = new ArrayList<>();
            for(String word: wordlist){
                if(matches == getMatches(guess, word)){
                    candidates.add(word);
                }
            }
            
            wordlist = candidates.toArray(new String[0]);
        }
    }
    
    private int getMatches(String word1, String word2){
        int matches = 0;
        for(int i = 0; i < word1.length(); i ++){
            if(word1.charAt(i) == word2.charAt(i)){
                matches ++;
            }
        }
        
        return matches;
    }
}