class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];

        // Initialize each child with 1 candy
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // Traverse from left to right
        for (int i = 1; i < n; i++) {
            // If current rating is higher than previous, give more candies
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            // If current rating is higher than next, adjust candy count
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Sum up all candies
        int total = 0;
        for (int c : candies) {
            total += c;
        }
        return total;
    }
}