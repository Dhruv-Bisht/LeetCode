import java.util.*;

class Solution {
    // A helper class to store the state (total weight and list of chosen indices)
    private static class State {
        long weight;
        List<Integer> indices;

        State(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    // A structured representation of the input intervals
    private static class Interval {
        int start, end, weight, id;

        Interval(int start, int end, int weight, int id) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.id = id;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervalsList) {
        int n = intervalsList.size();
        Interval[] intervals = new Interval[n];
        
        for (int i = 0; i < n; i++) {
            List<Integer> curr = intervalsList.get(i);
            intervals[i] = new Interval(curr.get(0), curr.get(1), curr.get(2), i);
        }

        // 1. Sort intervals primarily by start time to make binary searching forward seamless
        Arrays.sort(intervals, (a, b) -> a.start != b.start ? Integer.compare(a.start, b.start) : Integer.compare(a.end, b.end));

        // 2. Precompute the next valid non-overlapping interval using binary search
        int[] nextValid = new int[n];
        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n - 1;
            int ans = n;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (intervals[mid].start > intervals[i].end) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            nextValid[i] = ans;
        }

        // dp[i][j] stores the best State starting from interval i with j choices remaining
        State[][] dp = new State[n + 1][5];
        for (int j = 0; j <= 4; j++) {
            dp[n][j] = new State(0, new ArrayList<>());
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = new State(0, new ArrayList<>());
        }

        // 3. Process backward via DP
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= 4; j++) {
                // Scenario A: Skip current interval
                State skip = dp[i + 1][j];

                // Scenario B: Take current interval
                int nextIdx = nextValid[i];
                State nextState = dp[nextIdx][j - 1];
                
                long takeWeight = intervals[i].weight + nextState.weight;
                List<Integer> takeIndices = new ArrayList<>();
                takeIndices.add(intervals[i].id);
                takeIndices.addAll(nextState.indices);
                Collections.sort(takeIndices); // ensure the tracking indices remain sorted

                State take = new State(takeWeight, takeIndices);

                // Decide between Skip vs Take based on weight and lexicographical requirements
                if (take.weight > skip.weight) {
                    dp[i][j] = take;
                } else if (skip.weight > take.weight) {
                    dp[i][j] = skip;
                } else {
                    // Tie-breaker: Lexicographically smaller indices array wins
                    dp[i][j] = compareLexicographically(take.indices, skip.indices) <= 0 ? take : skip;
                }
            }
        }

        // Extract result from the optimal comprehensive state
        List<Integer> resList = dp[0][4].indices;
        int[] result = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            result[i] = resList.get(i);
        }
        return result;
    }

    private int compareLexicographically(List<Integer> a, List<Integer> b) {
        int len = Math.min(a.size(), b.size());
        for (int i = 0; i < len; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }
        return Integer.compare(a.size(), b.size());
    }
}
