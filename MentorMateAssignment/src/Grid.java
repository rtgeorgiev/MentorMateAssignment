public class Grid {

    private char[][] grid;
    private int row;
    private int col;
    private boolean isGridFilled;

    public Grid(int row, int col) {
        setRow(row);
        setColumn(col);
        this.grid = new char[row][];
        this.isGridFilled = false;
    }

    public char[][] getGrid() {
        return this.grid;
    }


    private void setRow(int row) {
        //Check if the width input is in the correct range
        if (row <= 0 || row > 999) {
            throw new IllegalArgumentException("Width must be between 1-1000");
        }
        this.row = row;
    }


    private void setColumn(int col) {
        //Check if the height input is in the correct range
        if (col <= 0 || col > this.row) {
            throw new IllegalArgumentException("Height must be between 1-1000 and must not be greater than the width");
        }
        this.col = col;
    }

    public boolean isGridFilled() {
        return this.isGridFilled;
    }

    public void fillGrid(String[] Rows) {
        if (Rows.length != this.row) {
            throw new IllegalArgumentException("Rows must be equal to " + this.row);
        }
        for (int i = 0; i < Rows.length; i++) {
            if (Rows[i].length() != this.col) {
                throw new IllegalArgumentException("Length of the sequence number " + (i + 1) + " must be " + this.col);
            }
            if (!Rows[i].matches("[0-1]+")) {
                throw new IllegalArgumentException("The input data must contain only 0 and 1");
            }
            grid[i] = Rows[i].toCharArray();

        }
        this.isGridFilled = true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (char[] chars : this.grid) {
            result.append(String.valueOf(chars));
            result.append(System.lineSeparator());
        }
        return result.toString();
    }
}