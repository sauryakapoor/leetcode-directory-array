import java.util.*;

class Solution {
    int[] a, b, len, seg;
    int m, z;

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length(), ones = 0;
        a = new int[n];
        b = new int[n];
        len = new int[n];

        for (int i = 0; i < n;) {
            if (s.charAt(i) == '1') {
                ones++;
                i++;
            } else {
                int j = i;
                while (j + 1 < n && s.charAt(j + 1) == '0') j++;
                a[m] = i;
                b[m] = j;
                len[m++] = j - i + 1;
                i = j + 1;
            }
        }

        z = 1;
        while (z < m) z <<= 1;
        seg = new int[z << 1];

        for (int i = 0; i + 1 < m; i++)
            seg[z + i] = len[i] + len[i + 1];

        for (int i = z - 1; i > 0; i--)
            seg[i] = Math.max(seg[i << 1], seg[i << 1 | 1]);

        List<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0], r = q[1], x = lower(b, m, l), y = upper(a, m, r) - 1, best = 0;

            if (x < y) {
                int left = b[x] - Math.max(a[x], l) + 1;
                int right = Math.min(b[y], r) - a[y] + 1;

                if (x + 1 == y) best = left + right;
                else best = Math.max(
                    Math.max(left + len[x + 1], len[y - 1] + right),
                    query(x + 1, y - 2)
                );
            }

            ans.add(ones + best);
        }

        return ans;
    }

    int lower(int[] x, int n, int v) {
        int l = 0, r = n;
        while (l < r) {
            int m = l + r >>> 1;
            if (x[m] >= v) r = m;
            else l = m + 1;
        }
        return l;
    }

    int upper(int[] x, int n, int v) {
        int l = 0, r = n;
        while (l < r) {
            int m = l + r >>> 1;
            if (x[m] <= v) l = m + 1;
            else r = m;
        }
        return l;
    }

    int query(int l, int r) {
        int res = 0;
        for (l += z, r += z; l <= r; l >>= 1, r >>= 1) {
            if ((l & 1) == 1) res = Math.max(res, seg[l++]);
            if ((r & 1) == 0) res = Math.max(res, seg[r--]);
        }
        return res;
    }
}