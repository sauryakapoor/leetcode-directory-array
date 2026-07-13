class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = duration;
        for (int i = 1; i < timeSeries.length; i++) 
        {
            int gap = timeSeries[i] - timeSeries[i - 1];
            total += Math.min(gap, duration);
        }
        return total;
    }
}