class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    perimeter += 4;

                    // Land cell connected with the cell above
                    if (i > 0 && grid[i - 1][j] == 1) {
                        perimeter -= 2;
                    }

                    // Land cell connected with the cell on the left
                    if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }

        return perimeter;
    }
}