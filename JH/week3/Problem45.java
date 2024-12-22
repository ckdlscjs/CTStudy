import java.util.*;

public class Problem45 {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Integer> stageCounts = new HashMap<>();
        List<int[]> st = new ArrayList<>();

        // Count occurrences of each stage
        for (int stage : stages) {
            stageCounts.put(stage, stageCounts.getOrDefault(stage, 0) + 1);
        }

        // Calculate failure rates for each stage
        for (int i = 1; i <= N; i++) {
            int cnt = stageCounts.getOrDefault(i, 0);
            int totalPlayers = cnt;

            for (int j = i + 1; j <= N + 1; j++) {
                totalPlayers += stageCounts.getOrDefault(j, 0);
            }

            double failureRate = (totalPlayers == 0) ? 0 : (double) stageCounts.getOrDefault(i, 0) / totalPlayers;
            st.add(new int[]{i, (int) failureRate});
        }

        // Sort by failure rate in descending order, and by stage number in ascending order if rates are equal
        st.sort((a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Double.compare(b[1], a[1]);
        });

        // Extract sorted stage numbers
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = st.get(i)[0];
        }

        return result;
    }
}
