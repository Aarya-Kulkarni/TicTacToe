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
                            if (checkHorizontalX() || checkVerticalX() || checkDiagonalTopRightBotLeft() || checkDiagonalTopLeftBotRight()) {
                                System.out.println();
                                screenOutput();
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
                            if (checkHorizontalO() || checkVerticalO() || checkDiagonalTopRightBotLeft() ||  checkDiagonalTopLeftBotRight()) {
                                System.out.println();
                                screenOutput();
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
                System.out.println();
                System.out.println("Do you want to play again?");
                System.out.println("(1) Yes");
                System.out.println("(2) No");
                System.out.println("-->");
                int u = console.nextInt();
                if (u == 1)
                    play();
                else
                    break;        
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
                            if (checkHorizontalX() || checkVerticalX() || checkDiagonalTopRightBotLeft() || checkDiagonalTopLeftBotRight()) {
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
                            if (checkHorizontalO() || checkVerticalO() || checkDiagonalTopRightBotLeft() || checkDiagonalTopLeftBotRight()) {
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
                System.out.println();
                System.out.println("Do you want to play again?");
                System.out.println("(1) Yes");
                System.out.println("(2) No");
                System.out.println("-->");
                int u = console.nextInt();
                if (u == 1)
                    play();
                else
                    break;                                                    
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

    public boolean checkHorizontalX() {     
        int rowNum = 0; 
        boolean win = false;
        int count = 0;       
        while (rowNum < board.length) {
            for (int i = 0; i < board.length - 1; i++) {
                if(board[rowNum][i] == board[rowNum][i + 1] && board[rowNum][i]!= "-")
                    count++;
            }
            if (count == board.length - 1) {
                win = true;
                count = 0;
            }  
            else {        
                count = 0;
            }
            rowNum++;
        }
        return win;
    }

    public boolean checkHorizontalO() {
        int rowNum = 0; 
        boolean win = false;
        int count = 0;       
        while (rowNum < board.length) {
            for (int i = 0; i < board.length - 1; i++) {
                if(board[rowNum][i] == board[rowNum][i + 1] && board[rowNum][i]!= "-")
                    count++;
            }
            if (count == board.length - 1) {
                win = true;
                count = 0;
            }  
            else {        
                count = 0;
            }
            rowNum++;
        }
        return win;
    }

    public boolean checkVerticalX() {
        int colNum = 0; 
        boolean win = false;
        int count = 0;       
        while (colNum < board.length) {
            for (int i = 0; i < board.length - 1; i++) {
                if(board[i][colNum] == board[i + 1][colNum] && board[i][colNum]!= "-")
                    count++;
            }
            if (count == board.length - 1) {
                win = true;
                count = 0;
            }  
            else {        
                count = 0;
            }
            colNum++;
        }
        return win;
    }

    public boolean checkVerticalO() {
        int colNum = 0; 
        boolean win = false;
        int count = 0;       
        while (colNum < board.length) {
            for (int i = 0; i < board.length - 1; i++) {
                if(board[i][colNum] == board[i + 1][colNum] && board[i][colNum]!= "-")
                    count++;
            }
            if (count == board.length - 1) {
                win = true;
                count = 0;
            }  
            else {        
                count = 0;
            }
            colNum++;
        }
        return win;
    }

    public boolean checkDiagonalTopLeftBotRight() {
        //int diagNum = 0; 
        //oolean win = false;
        int count = 0;       
        for (int row = 0; row < board.length - 1; row++) {
            for (int col = 0; col < board[0].length - 1; col++) {
                if(board[row][col] == board[row + 1][col + 1] && board[row][col]!= "-")
                    count++;
            }
        }
        if (count == board.length - 1) {
            return true;                
        }  
        
        return false;
    }
    
    public boolean checkDiagonalTopRightBotLeft() {
        int count = 0;
        for (int row = 0 ; row < board.length - 1; row++) {
            for (int col = board[0].length - 1; col > 0; col--) {
                if(board[row][col] ==  board[row + 1][col - 1] && board[row][col]!= "-")
                    count++;
            }
        }
        if (count == board.length - 1) {
            return true;
        }        
        return false;
    }
}
