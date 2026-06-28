class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int[] pge = previousGreater(nums);
        int[] ngee = nextGreaterEqual(nums);

        int[] pse = previousSmaller(nums);
        int[] nsee = nextSmallerEqual(nums);

        long maxSum = 0;
        long minSum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = ngee[i] - i;
            maxSum += (long) nums[i] * left * right;
        }

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nsee[i] - i;
            minSum += (long) nums[i] * left * right;
        }

        return maxSum - minSum;
    }

    // Previous Greater (>)
    private int[] previousGreater(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i])
                st.pop();

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    // Next Greater or Equal (>=)
    private int[] nextGreaterEqual(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i])
                st.pop();

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }

    // Previous Smaller (<)
    private int[] previousSmaller(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i])
                st.pop();

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    // Next Smaller or Equal (<=)
    private int[] nextSmallerEqual(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i])
                st.pop();

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
}