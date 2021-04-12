public class IslandCounting {
    static char[][] grid;
    static int size;
    static boolean visited[][];

    static boolean inside(int row, int col) {
        return row >= 0 && col >= 0 && row < 6 && col < 5;
    }

    static void dfs(int row, int col) {
        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};
        size++;
        visited[row][col] = true;
        for (int d = 0; d < 4; d++) {
            int newRow = grid[row][col] * dr[d] + row;
            int newCol = dc[d] + col;
            if (inside(newRow, newCol) && !visited[newRow][newCol] &&
                    grid[newRow][newCol] == '#') {
                dfs(newRow, newCol);
            }
        }
    }

    public static void main(String[] args) {
        grid = new char[][]{
                {'#', '#', '.', '#', '.'},
                {'#', '#', '.', '#', '.'},
                {'#', '#', '.', '.', '.'},
                {'#', '.', '.', '.', '.'},
                {'.', '.', '.', '#', '#'},
                {'.', '.', '.', '#', '.'},
        };
        visited = new boolean[grid.length][grid[0].length];
        int n = grid.length;
        int islands = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // We want to do a DFS if it's lands AND it's not viisted
                if (grid[i][j] == '#' && !visited[i][j]) {
                    size = 0;
                    islands++;
                    dfs(i, j);
                    System.out.println("This island has a size of " + size);
                }
            }
        }
        System.out.println("There are " + islands + " islands");
    }
}
