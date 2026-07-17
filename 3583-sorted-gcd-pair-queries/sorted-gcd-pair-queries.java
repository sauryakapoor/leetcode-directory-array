class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxValue = 0;
        for (int num : nums) 
        {
            maxValue = Math.max(maxValue, num);
        }
        int[] freq = new int[maxValue + 1];
        for (int num : nums) 
        {
            freq[num]++;
        }
        long[] exactGcd = new long[maxValue + 1];
        for (int g = maxValue; g >= 1; g--) 
        {
            long divisibleCount = 0;
            for (int multiple = g; multiple <= maxValue; multiple += g) 
            {
                divisibleCount += freq[multiple];
            }
            long pairs = divisibleCount * (divisibleCount - 1) / 2;
            for (int multiple = g + g; multiple <= maxValue; multiple += g) 
            {
                pairs -= exactGcd[multiple];
            }
            exactGcd[g] = pairs;
        }
        long[] prefix = new long[maxValue + 1];
        for (int g = 1; g <= maxValue; g++) 
        {
            prefix[g] = prefix[g - 1] + exactGcd[g];
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) 
        {
            long query = queries[i];
            int left = 1;
            int right = maxValue;
            while (left < right)
            {
                int mid = left + (right - left) / 2;
                if (prefix[mid] > query) 
                {
                    right = mid;
                } 
                else 
                {
                    left = mid + 1;
                }
            }
            answer[i] = left;
        }
        return answer;
    }
}