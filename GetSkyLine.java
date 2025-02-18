class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
         List<int[]> events = new ArrayList<>();
        
        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]});
            events.add(new int[]{b[1], b[2]}); 
        }

        events.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(0); 
        int prevMaxHeight = 0;
        
        for (int[] event : events) {
            int x = event[0], h = event[1];
            
            if (h < 0) { 
                maxHeap.add(-h);
            } else { 
                maxHeap.remove(h);
            }
            
            int currMaxHeight = maxHeap.peek();
            if (currMaxHeight != prevMaxHeight) {
                result.add(Arrays.asList(x, currMaxHeight));
                prevMaxHeight = currMaxHeight;
            }
        }
        
        return result;
        
    }
}
/*
Input
buildings =
[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
Output
[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
Expected
[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]*/
