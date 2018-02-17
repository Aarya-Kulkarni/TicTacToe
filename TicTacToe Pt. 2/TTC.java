import java.util.*;
/**
 * Write a description of class TTC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TTC
{
    private String [][] board; 
    private Scanner console;
    private int a;
    private int dimension;
    /*
    public TTC(int size) {
    board = new String [size][size];
    dimension = size;
    }
     */
    public void play() {
        String choice;
        String print;
        console = new Scanner(System.in);
        String markX = "X";
        String markO = "O";
        //Trying to make the decision to choose the dimensions of the board in the console.
        System.out.println("What do you want the dimensions of the board to be? ");
        System.out.print("--> ");
        int m = console.nextInt();
        board = new String [m][m];

        do {
            System.out.println();
            System.out.println("Tic Tac Toe:");
            System.out.println();
            System.out.println("(1) Two Players");
            System.out.println("(2) Single Player");
            System.out.println("(Q) Quit");
            System.out.println();
            System.out.print("Choice --> ");
            choice = console.next() + " ";

            if ('1' == choice.charAt(0)) {
                System.out.println();
                System.out.println("Board Set To:");
                System.out.println();
                reset();
                screenOutput();
                System.out.println();
                System.out.println("Player 1 = X          Player 2 = O");
                //System.out.println();
                do {
                    if (a == 0) {
                        //do {
                        System.out.println();
                        System.out.println("Player 1:");
                        System.out.println();
                        System.out.print("X Coordinate: ");
                        int x = console.nextInt();
                        System.out.print("Y Coordinate: ");
                        int y = console.nextInt();
                        System.out.println();
                        if (checkSpot(x, y)) {
                            move(markX, x, y);
                            if (checkHorizontalX() /*|| checkVerticalX() || checkDiagonalX()*/) {
                                System.out.println();
                                System.out.println("Player 1 is the winner!");
                                break;
                            }
                            screenOutput();
                            a++;                                
                        }

                        else {
                            System.out.println();    
                            System.out.println("Spot Taken");
                            //screenOutput();
                        }

                        //} while (check());

                    }
                    else  {
                        //do {
                        System.out.println();
                        System.out.println("Player 2:");
                        System.out.println();
                        System.out.print("X Coordinate: ");
                        int x = console.nextInt();
                        System.out.print("Y Coordinate: ");
                        int y = console.nextInt();
                        System.out.println();
                        if (checkSpot(x, y)) {
                            move(markO, x, y);
                            if (checkHorizontalO() || checkVerticalO() || checkDiagonalO()) {
                                System.out.println();
                                System.out.println("Player 2 is the winner!");
                                break;
                            }
                            screenOutput();
                            a--;
                        }

                        else {
                            System.out.println();
                            System.out.println("Spot Taken");
                            //screenOutput();
                        }
                        //} while (check());
                        //a = 0;
                    }
                } while (check());
            }
            if ('2' == choice.charAt(0)) {
                System.out.println();
                System.out.println("Board Set To:");
                System.out.println();
                reset();
                screenOutput();
                System.out.println();
                System.out.println("You = X          Computer = O");
                System.out.println();
                do {
                    if (a == 0) {
                        //do {
                        System.out.println();
                        System.out.println("Your Move:");
                        System.out.println();                       
                        System.out.print("X Coordinate: ");
                        int x = console.nextInt();             
                        System.out.print("Y Coordinate: ");
                        int y = console.nextInt();
                        System.out.println();
                        if (checkSpot(x, y)) {
                            move(markX, x, y);
                            if (checkHorizontalX() || checkVerticalX() || checkDiagonalX()) {
                                System.out.println();
                                screenOutput();
                                System.out.println("You are the winner!");
                                break;
                            }
                            screenOutput();
                            a++;                                
                        }

                        else {
                            System.out.println();    
                            System.out.println("Spot Taken");
                            //screenOutput();
                        }

                        //} while (check());

                    }
                    else  {
                        //do {
                        System.out.println();
                        System.out.println("Computer:");
                        System.out.println();
                        //System.out.print("X Coordinate: ");
                        int x = (int) (Math.random() * 3);
                        //System.out.print("Y Coordinate: ");
                        int y = (int) (Math.random() * 3);
                        System.out.println();
                        if (checkSpot(x, y)) {
                            move(markO, x, y);
                            if (checkHorizontalO() || checkVerticalO() || checkDiagonalO()) {
                                System.out.println();
                                screenOutput();
                                System.out.println("You got beaten by a computer!");
                                break;
                            }
                            screenOutput();
                            a--;
                        }

                        else {
                            System.out.println();
                            System.out.println("Spot Taken");
                            //screenOutput();
                        }
                        //} while (check());
                        //a = 0;
                    }
                } while (check());
            }

        } while (choice.charAt(0) == '1' && choice.charAt(0) == '2'); 
    }    

    private void reset() {
        for (int row = 0; row < board.length; row++)             
            for (int col = 0; col < board[0].length; col++) 
                board[row][col] = "-";     
    }

    private void screenOutput() {
        for (int row = 0; row < board.length; row++) {
            //System.out.print("empty"); 
            for (int col = 0; col < board[0].length; col++) {                
                System.out.printf(board[row][col] + "  ");           
            }
            System.out.println(" ");
        }
    }

    public void move(String marker, int row, int col) {
        board[row][col] = marker;
    }

    public boolean checkSpot(int row, int col) {
        if (board[row][col] == "-")
            return true;
        return false;
    }

    public boolean check(){
        boolean checker = false;
        for (int row = 0; row < board.length; row++)             
            for (int col = 0; col < board[0].length; col++) 
                if (board[row][col] == "-") 
                    checker = true;

        return checker;
    }

    /*
    public boolean checkHorizontalX() {
    //first row horizontal
    if (board[0][0] == "X" && board[0][1] == "X" && board[0][2] == "X") 
    return true;

    //second row horizontal
    if (board[1][0] == "X" && board[1][1] == "X" && board[1][2] == "X")
    return true;

    //third row horizontal
    if (board[2][0] == "X" && board[2][1] == "X" && board[2][2] == "X")
    return true;

    return false;
    }
     */

    public boolean checkHorizontalX() {
        int rowNum = 0;
        boolean win = false;
        while (rowNum < board.length) {
            for (int i = 0; i < board.length; i++) {
                if (board[rowNum][i] == "O") {
                    win = false;
                    //return true;
                }
            }
            rowNum++;        
        }
        return win;
    }
    public boolean checkHorizontalO() {
        //first row horizontal

        if (board[0][0] == "O" && board[0][1] == "O" && board[0][2] == "O")
            return true;
        //second row horizontal

        if (board[1][0] == "O" && board[1][1] == "O" && board[1][2] == "O")
            return true;    
        //third row horizontal

        if (board[2][0] == "O" && board[2][1] == "O" && board[2][2] == "O")
            return true;   
        return false;
    }

    public boolean checkVerticalX() {
        //first column vertical 
        if (board[0][0] == "X" && board[1][0] == "X" && board[2][0] == "X") 
            return true;

        //second column vertical
        if (board[0][1] == "X" && board[1][1] == "X" && board[2][1] == "X")
            return true;

        //third column vertical
        if (board[0][2] == "X" && board[1][2] == "X" && board[2][2] == "X")
            return true;

        return false;
    }

    public boolean checkVerticalO() {
        //first column vertical 

        if (board[0][0] == "O" && board[1][0] == "O" && board[2][0] == "O")
            return true;
        //second column vertical

        if (board[0][1] == "O" && board[1][1] == "O" && board[2][1] == "O")
            return true;    
        //third column vertical

        if (board[0][2] == "O" && board[1][2] == "O" && board[2][2] == "O")
            return true;   
        return false;
    }

    public boolean checkDiagonalX() {
        //top to bottom (left to right)
        if (board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X") 
            return true;

        //bottom to top (right to left)
        if (board[2][0] == "X" && board[1][1] == "X" && board[0][2] == "X") 
            return true;

        return false;
    }

    public boolean checkDiagonalO() {
        //top to bottom (left to right)

        if (board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O")
            return true;
        //bottom to top (right to left)

        if (board[2][0] == "O" && board[1][1] == "O" && board[0][2] == "O")
            return true;
        return false;
    }

    /*
    public int AImove() {
    //check horizontal

    for (int row = 0; i < board.length; row++) {
    for (int col = 0; board[0].length; col++) {
    if (board[
    }
    }

    }
     */
}
