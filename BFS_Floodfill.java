import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Example {

    public static boolean inBounds(int rows, int cols, int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '1'},
                {'1', '2', '3', '3', '2'},
                {'3', '3', '3', '3', '5'},
                {'5', '2', '4', '3', '4'},
                {'4', '3', '1', '3', '4'},
                {'5', '3', '5', '3', '2'},
        };
        // This is an example of floodfill (used in MS Paint,etc) that replaces
        //  squares of adjacent colors with another color
        // This example replaces the color 3 at square (2,2) and all its neighbors with the color '6'
        int rows = grid.length, cols = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(2, 2));

        int[] xs = {-1, 0, 1, 0};
        int[] ys = {0, 1, 0, -1};
        boolean[][] visited = new boolean[rows][cols];

        while (!q.isEmpty()) {
            Pair top = q.poll();
            if (visited[top.row][top.column]) continue;
            visited[top.row][top.column] = true;
            grid[top.row][top.column] = '6';

            for (int d = 0; d < 4; d++) {
                int newRow = top.row + xs[d];
                int newCol = top.column + ys[d];
                if (inBounds(rows, cols, newRow, newCol) && grid[newRow][newCol] == '3')
                    q.add(new Pair(newRow, newCol));
            }
        }

        for(char [] a: grid) System.out.println(Arrays.toString(a));

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
