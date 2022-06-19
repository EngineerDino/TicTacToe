package tictactoe;
import java.util.*;


public class Main {

    public static void printBoard(String[][] board) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.print(" |" + "\n");
        }
        System.out.println("---------");
    }


    public static String checkState(String[][] board) {
        //I save all rows and columns and the 2 diagonals in one string separated by a "-" symbol.
        //Then i only have to check this string, if there is "XXX" or "OOO" occuring in that wCheck.
        String wCheck = " ";
        for (int i = 0; i < 3; i++) {
            wCheck += board[i][0] + board[i][1] + board[i][2] + "-" + board[0][i] + board[1][i] + board[2][i] + "-";
        }
        wCheck += board[0][0] + board[1][1] + board[2][2] + "-" + board[0][2] + board[1][1] + board[2][0];

        if (wCheck.contains("XXX")) {
            return "X wins";
        } else if (wCheck.contains("OOO")) {
            return "O wins";
        } else if (!wCheck.contains("_")) {
            return "Draw";
        } else {
            return "Continue";
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] board = {{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}};
        String output = " ";
        int activePlayer = 1;
        String symbol = "X";
        int rowInput = 0;
        int colInput = 0;
        boolean isInteger = true;


        printBoard(board);


        // ****************  Big Infinite loop to post a "X" or "O" until win or draw   ****************************
        while(true) {

            switch (activePlayer) {
                case 1:
                    symbol = "X";
                    activePlayer = 2;
                    break;
                case 2: symbol = "O";
                    activePlayer = 1;
                    break;
            }

            //Now we get the input from the Player in form of coordinates row col in another infinite loop

            while(true) {
                System.out.print("Enter the coordinates:");

                //Check if the next two Inputs are Integers and if so, save them.
                isInteger = scanner.hasNextInt();
                rowInput = isInteger ? scanner.nextInt() : 0;
                isInteger = scanner.hasNextInt();
                colInput = isInteger ? scanner.nextInt() : 0;

                //Check for all kinds of wrong input and save "X" or "O" in the board if everything is ok.
                if (!isInteger) {
                    System.out.println("You should enter numbers!");
                } else if (rowInput > 3 || rowInput < 1 || colInput > 3 || colInput < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (!board[rowInput - 1][colInput - 1].equals("_")) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    board[rowInput - 1][colInput - 1] = symbol;
                    break;
                }
                //Make sure the scanner reads the whole line such that he is done and "reset" for the next run of the loop
                scanner.nextLine();

                //End of smaller infinite while to post one Symbol
            }

            //Print the board again
            printBoard(board);

            //Check if there is a winner or a draw. If so, break, otherwise continue.
            output = checkState(board);
            if (!output.equals("Continue")) {
                break;
            }

        }
        // **************** End of Big Infinite loop to post a "X" or "O" until win or draw   ****************************
        //Only print the winner or the draw

        System.out.println(output);



        //******* Down here is old stuff from the previous parts not used here *****************

       /* //First check, if the difference in "X" and "O" is at most 1
        int checksum = 0;
        for (int i = 0; i < 3; i++) {
            for (String val : board[i]) {
                checksum += val.equals("X") ? 1 : val.equals("O") ? -1 : 0;
            }
        }

         If difference bigger than 1, we are done.
          Otherwise:
        - Check if X has 3 in a row
        - Check if O has 3 in a row.
        - If both true, its impossible, if only one true, then that dude won.
        - If nothing checks out, we are either still playing (if at least one "_") or have a draw.



        if (Math.abs(checksum) > 1) {
            output = "Impossible";
        } else {
            // Fill a String with all rows, all columns and the two diagonals always separated by a random character.
            String wCheck = " ";
            for (int i = 0; i < 3; i++) {
                    wCheck += board[i][0] + board[i][1] + board[i][2] + "-" + board[0][i] + board[1][i] + board[2][i] + "-";
            }
            wCheck += board[0][0] + board[1][1] + board[2][2] + "-" + board[0][2] + board[1][1] + board[2][0];

            //wCheck = wCheck.toUpperCase();
            if (wCheck.contains("XXX")) {
                output = wCheck.contains("OOO") ? "Impossible" : "X wins";
            } else if (wCheck.contains("OOO")) {
                output = "O wins";
            } else if (!wCheck.contains("_")) {
                output = "Draw";
            } else {
                output = "Game not finished";
            }
        }
        //Print the result!!
        System.out.println(output); */



    }
}
