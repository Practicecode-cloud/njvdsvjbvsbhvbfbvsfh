import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        GameLogic gameLogic = new GameLogic();

        System.out.print("Enter First player name:");
        String name1 = scanner.nextLine();
        Player player1 = new Player(name1,'X');

        System.out.print("Enter Second player name:");
        String name2 = scanner.nextLine();
        Player player2 = new Player(name2,'O');

        Player currentPlayer = player1;

        while (true)
        {
            board.printBoard();

            System.out.println(currentPlayer.getName()+"("+currentPlayer.getSymbol()+")");
            int row = scanner.nextInt();
            int column = scanner.nextInt();

            if (!board.placeMove(row,column,currentPlayer.getSymbol()))
            {
                System.out.println("Spot already taken");
                continue;
            }

            if (gameLogic.checkWin(board.getBoard(), currentPlayer.getSymbol() ))
            {
                board.printBoard();
                System.out.println(currentPlayer.getName()+" Wins");
                break;
            }

            if (gameLogic.isBoardFull(board.getBoard()))
            {
                board.printBoard();
                System.out.println("Its a draw");
                break;
            }

            if (currentPlayer == player1)
            {
                currentPlayer = player2;
            }
            else
            {
                currentPlayer = player1;
            }
        }
    }
}