import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Maze {

    public static boolean inBounds(int rows, int cols, int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'@', '@', '@', '@', '@', '@', '@'},
                {'@', ' ', '@', ' ', ' ', ' ', '@'},
                {'@', ' ', '@', ' ', 'S', ' ', '@'},
                {'@', ' ', '@', ' ', ' ', ' ', '@'},
                {'@', ' ', '@', ' ', ' ', ' ', '@'},
                {'@', ' ', ' ', '@', ' ', '@', '@'},
                {'@', ' ', ' ', ' ', ' ', '@', '@'},
                {'@', ' ', ' ', '@', ' ', ' ', '@'},
                {'@', ' ', ' ', '@', ' ', ' ', '@'},
                {'@', '@', '@', '@', '@', '@', '@'},
        };
        int rows = grid.length, cols = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(2, 4));

        int[] xs = {-1, 0, 1, 0};
        int[] ys = {0, 1, 0, -1};
        // visited[row][col] : have we visited the square at position (row, col) ?
        boolean[][] visited = new boolean[rows][cols];
        // steps[row][col] : how far from the start is (row, col) ?
        int[][] steps = new int[rows][cols];

        while (!q.isEmpty()) {
            Pair top = q.poll();
            // If we've already visited a square, we don't want to do stuff with it again
            if (visited[top.row][top.column]) continue;
            // If we've not already visited this square, well we're doing it right now so set it to visited
            //  so that our code doesn't keep repeating the same squares and getting stuck in a loop.
            visited[top.row][top.column] = true;

            for (int d = 0; d < 4; d++) {
                int newRow = top.row + xs[d];
                int newCol = top.column + ys[d];
                // Only want to add neighboring squares if 
                // 1. inbounds
                // 2. It is a space
                // 3. It has not been visited
                if (inBounds(grid.length, grid[0].length, newRow, newCol) && grid[newRow][newCol] == ' '
                        && !visited[newRow][newCol]) {
                    q.add(new Pair(newRow, newCol));
                // We already know the distance from "top". 
                //  Because (newRow, newCol) is a neighboring square, we know the distance is just is
                //  1 + steps for top  because to get to (newRow, newCol), we have to take 1 extra step.
                    steps[newRow][newCol] = steps[top.row][top.column] + 1;
                }
            }
        }

        for (int[] a : steps) System.out.println(Arrays.toString(a));

    }

    public static class Pair {
        int row, column;

        public Pair(int i, int j) {
            row = i;
            column = j;
        }

        public Pair(Pair p) {
            row = p.row;
            column = p.column;
        }

        public String toString() {
            return row + "," + column;
        }

    }
}
