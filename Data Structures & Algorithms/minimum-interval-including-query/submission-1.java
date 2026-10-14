class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        int n = queries.length;
        int[][] qPairs = new int[n][2];
        for(int i = 0;i<n;i++){
            qPairs[i][0] = queries[i];
            qPairs[i][1] = i;
        }
        Arrays.sort(qPairs, Comparator.comparingInt(a->a[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        int res[] = new int[n];
        Arrays.fill(res,-1);
        int i = 0;
        for(int[] q:qPairs){
            int query = q[0];
            int idx = q[1];
            while(i<intervals.length && intervals[i][0]<= query){
                int left = intervals[i][0], right = intervals[i][1];
                int size = right-left+1;
                minHeap.offer(new int[]{size, right});
                i++;
            }
            while(!minHeap.isEmpty() && minHeap.peek()[1] < query){
                minHeap.poll();
            }
            if(!minHeap.isEmpty()){
                res[idx] = minHeap.peek()[0];
            }
        }
        return res;
    }
}
