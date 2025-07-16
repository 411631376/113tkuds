import java.util.Scanner;

public class TicTacToe5x5 {
    static final int SIZE = 5;
    static final char EMPTY = '.';
    static char[][] board = new char[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initBoard();
        char currentPlayer = 'X';
        int moves = 0;

        while (true) {
            printBoard();
            System.out.printf("玩家 %c 請輸入 row col (0~4): ", currentPlayer);
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (!isValidMove(row, col)) {
                System.out.println("輸入錯誤或該位置已被佔用，請重新輸入！");
                continue;
            }

            board[row][col] = currentPlayer;
            moves++;

            if (checkWin(currentPlayer)) {
                printBoard();
                System.out.println("玩家 " + currentPlayer + " 獲勝！");
                break;
            } else if (moves == SIZE * SIZE) {
                printBoard();
                System.out.println("平手！");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    static void initBoard() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = EMPTY;
    }

    static void printBoard() {
        System.out.println("=== 5x5 井字遊戲 ===");
        System.out.print("  ");
        for (int j = 0; j < SIZE; j++) System.out.print(j + " ");
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == EMPTY;
    }

    static boolean checkWin(char player) {
        // 橫向
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j <= SIZE - 5; j++)
                if (allFive(player, i, j, 0, 1)) return true;
        // 直向
        for (int i = 0; i <= SIZE - 5; i++)
            for (int j = 0; j < SIZE; j++)
                if (allFive(player, i, j, 1, 0)) return true;
        // 主對角線
        for (int i = 0; i <= SIZE - 5; i++)
            for (int j = 0; j <= SIZE - 5; j++)
                if (allFive(player, i, j, 1, 1)) return true;
        // 反對角線
        for (int i = 0; i <= SIZE - 5; i++)
            for (int j = 4; j < SIZE; j++)
                if (allFive(player, i, j, 1, -1)) return true;

        return false;
    }

    static boolean allFive(char player, int startRow, int startCol, int dr, int dc) {
        for (int k = 0; k < 5; k++)
            if (board[startRow + k * dr][startCol + k * dc] != player)
                return false;
        return true;
    }
}