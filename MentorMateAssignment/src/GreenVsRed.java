import java.util.Scanner;

public class GreenVsRed {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sizeAnswer = scanner.nextLine();
        String[] size = sizeAnswer.split(", ");

        //Determine the size of the grid by number of rows and columns
        int x = Integer.parseInt(size[0]);
        int y = Integer.parseInt(size[1]);

        try {
        //Create the grid
        Grid grid = new Grid(x, y);

        //Create String array and fill it with rows
        String[] Rows = new String[x];

        for (int i = 0; i < x; i++) {
            String Row = scanner.nextLine();
            Rows[i] = Row;
        }

        //Fill the grid with cells
        grid.fillGrid(Rows);

        GameField gf = new GameField(grid);
        String inputGameAnswer = scanner.nextLine();
        String[] inputGame = inputGameAnswer.split(", ");
        int yCol = Integer.parseInt(inputGame[0]);
        int xRow = Integer.parseInt(inputGame[1]);
        int generationNumber = Integer.parseInt(inputGame[2]);

        int greenColourGenerationCount = gf.play(xRow, yCol, generationNumber);
        System.out.println("# expected result: " + greenColourGenerationCount);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}}

