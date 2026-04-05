class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] freq = new int[26];
        for (char t : tasks) freq[t - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int f : freq) {
            if (f > 0) pq.offer(f);
        }

        int time = 0;

        while (!pq.isEmpty()) {

            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            while (cycle > 0 && !pq.isEmpty()) {
                int f = pq.poll();
                if (f - 1 > 0) temp.add(f - 1);
                time++;
                cycle--;
            }

            for (int f : temp) pq.offer(f);

            if (pq.isEmpty()) break;

            time += cycle; // idle time
        }

        return time;
    }
}
