class Solution {
    public int maxProduct(int n) {
        int l = 0, s = 0;
        while (n > 0) 
        {
            int digit = n % 10;
            n /= 10;
            if (digit >= l) 
            {
                s = l;
                l = digit;
            } 
            else if (digit > s) 
            {
                s = digit;
            }
        }
        return l * s;
    }
}