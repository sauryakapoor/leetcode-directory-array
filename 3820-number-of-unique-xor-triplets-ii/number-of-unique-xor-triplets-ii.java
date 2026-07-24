class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] present = new boolean[2048];
        boolean[] pairXor = new boolean[2048];
        boolean[] tripletXor = new boolean[2048];
        for (int x : nums) present[x] = true;
        for (int a = 0; a < 2048; a++)
            if (present[a])
                for (int b = 0; b < 2048; b++)
                    if (present[b])
                        pairXor[a ^ b] = true;
        for (int ab = 0; ab < 2048; ab++)
            if (pairXor[ab])
                for (int c = 0; c < 2048; c++)
                    if (present[c])
                        tripletXor[ab ^ c] = true;
        int count = 0;
        for (boolean value : tripletXor)
            if (value) count++;
        return count;
    }
}