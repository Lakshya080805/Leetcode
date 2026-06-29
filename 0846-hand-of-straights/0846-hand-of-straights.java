class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0)return false;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        Map<Integer,Integer> mpp=new HashMap<>();
        for(int num:hand){
            mpp.put(num,mpp.getOrDefault(num,0)+1);
        }
        Arrays.sort(hand);
        pq.add(hand[0]);
        for(int i=1;i<n;i++){
            if(hand[i]!=hand[i-1]){
                pq.add(hand[i]);
            }
        }

        while(!pq.isEmpty()){
            int start=pq.peek();
            for(int i=0;i<groupSize;i++){
                int curr=start+i;
                if(!mpp.containsKey(curr)){
                    return false;
                }
                mpp.put(curr,mpp.get(curr)-1);

                if (mpp.get(curr) == 0) {
                    if (curr != pq.peek()) {
                        return false;
                    }
                    pq.poll();
                    mpp.remove(curr);
                }
            }
        }
        return true;


    }
}