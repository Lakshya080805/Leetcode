class MedianFinder {
    private PriorityQueue<Integer> low;
    private PriorityQueue<Integer> high;

    public MedianFinder() {
        // Max heap for lower half
        low=new PriorityQueue<>(Collections.reverseOrder());
        // Min heap for upper half
        high = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Step 1: Add to max heap first
        low.offer(num);

        // Step 2: Balance heaps - move max from low to high
        high.offer(low.poll());

        // Step 3: Maintain size property (low >= high)
        if (low.size() < high.size()) {
            low.offer(high.poll());
        }
    }
    
    public double findMedian() {
        if (low.size() == high.size()) {
            return (low.peek() + high.peek()) / 2.0;
        } else {
            return low.peek(); // always the middle if odd
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */