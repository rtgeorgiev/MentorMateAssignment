import java.util.ArrayDeque;

public class GameField {
    private Grid grid;

    public GameField(Grid grid) {
        if (!grid.isGridFilled()) {
            throw new IllegalStateException("The grid is empty");
        }
        this.grid = grid;
    }

    public int play(int row, int col, int numberOfGenerations) {
        char[][] grid = this.grid.getGrid();

        if (!isInBoundries(row, col, grid)) {
            throw new IllegalArgumentException("Invalid coordinate");
        }

        ArrayDeque<int[]> redDeque = new ArrayDeque<>();
        ArrayDeque<int[]> greenDeque = new ArrayDeque<>();

        int generationsCounter = 0;

        for (int i = 0; i <= numberOfGenerations; i++) {

            if (grid[row][col] == '1') {
                generationsCounter++;
            }

            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[r].length; c++) {
                    int greenNeighbours = getGreenNeighbours(grid, r, c);

                    if (grid[r][c] == '1') {
                        if (greenNeighbours != 2 && greenNeighbours != 3 && greenNeighbours != 6) {
                            redDeque.push(new int[]{r, c});
                        }
                    } else {
                        if (greenNeighbours == 3 || greenNeighbours == 6) {
                            greenDeque.push(new int[]{r, c});
                        }
                    }
                }
            }
            //Change green cells into red
            while (!redDeque.isEmpty()) {
                int[] currentCell = redDeque.pop();
                grid[currentCell[0]][currentCell[1]] = '0';
            }
            //Change red cells into green
            while (!greenDeque.isEmpty()) {
                int[] currentCell = greenDeque.pop();
                grid[currentCell[0]][currentCell[1]] = '1';
            }
        }
        return generationsCounter;
    }

    private static int getGreenNeighbours(char[][] matrix, int row, int col) {
        int greenNeighboursCount = 0;
        for (int x = row - 1; x < row + 2; x++) {
            for (int y = col - 1; y < col + 2; y++) {
                if (isInBoundries(x, y, matrix) && !(row == x && col == y) && matrix[x][y] == '1') {
                    greenNeighboursCount++;
                }
            }
        }
        return greenNeighboursCount;
    }

    private static boolean isInBoundries(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

}