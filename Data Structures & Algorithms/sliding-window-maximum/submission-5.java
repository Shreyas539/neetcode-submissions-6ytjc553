class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         Deque<Integer> q = new ArrayDeque<>(); // stores indices
        int n = nums.length;
        int[] output = new int[n - k + 1];
        int idx = 0;

        for (int r = 0; r < n; r++) {

            // 1️⃣ Remove smaller elements from back
            while (!q.isEmpty() && nums[q.peekLast()] < nums[r]) {
                q.pollLast();
            }

            // 2️⃣ Add current index
            q.offerLast(r);

            // 3️⃣ Remove elements outside window
            if (!q.isEmpty() && q.peekFirst() <= r - k) {
                q.pollFirst();
            }

            // 4️⃣ Window formed
            if (r >= k - 1) {
                output[idx++] = nums[q.peekFirst()];
            }
        }

        return output;
        
    }

    
}
