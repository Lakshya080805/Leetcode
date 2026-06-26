class Solution {
    public int reversePairs(int[] nums) {

        return divide(nums, 0, nums.length - 1);

    }

    public static void conquer(int[] nums, int low, int mid, int high) {
        int[] merged = new int[high-low+1];
        int left = low;
        int right = mid + 1;
        int x = 0;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                merged[x] = nums[left];
                left++;
                x++;
            } else {
                merged[x] = nums[right];
                right++;
                x++;
            }
        }
        while (left <= mid) {
            merged[x] = nums[left];
            left++;
            x++;
        }
        while (right <= high) {
            merged[x] = nums[right];
            right++;
            x++;
        }
        // for (int i =0; i < merged.length; i++) {
            
        //     nums[low+i]=merged[i];
        // }
        for(int i=low;i<=high;i++){
            nums[i] = merged[i - low];
        }
    }

    public static int countPairs(int[] nums, int low, int mid, int high) {
        int right = mid + 1;
        int count = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && nums[i] >(long) 2 * nums[right]) {
                right++;

            }
            count += (right - (mid + 1));

        }
        return count;
    }

    public static int divide(int[] nums, int low, int high) {
        int count = 0;
        if (low >= high) {
            return count;
        }
        int mid = (low + high) / 2;
        count += divide(nums, low, mid);
        count += divide(nums, mid + 1, high);
        count += countPairs(nums, low, mid, high);
        conquer(nums, low, mid, high);
        return count;
    }
}