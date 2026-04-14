import java.util.Random;

public class MyProgram {

    private static final int big = 9; // size 9
    private static Random rand = new Random();

    public static void main(String[] args) {
        int[][] board = new int[big][big]; // 2d array for the board
        fill(board);
        print(board);
    }

    // Backtracking fill
    private static boolean fill(int[][] board) {
        for (int r = 0; r < big; r++) {
            for (int c = 0; c < big; c++) {
                if (board[r][c] == 0) {
                    int[] nums = randomOrder();
                    for (int n = 0; n < big; n++) {
                        int val = nums[n];
                        if (safe(board, r, c, val)) {
                            board[r][c] = val;
                            if (fill(board)) {
                                return true;
                            }
                            board[r][c] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    // Check row, column, and 3×3 box
    private static boolean safe(int[][] board, int r, int c, int val) {
        for (int i = 0; i < big; i++) {
            if (board[r][i] == val) return false;
            if (board[i][c] == val) return false;
        }

        int boxR = (r / 3) * 3;
        int boxC = (c / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxR + i][boxC + j] == val) return false;
            }
        }
        return true;
    }

    // Return numbers 1–9 in random order
    private static int[] randomOrder() {
        int[] a = {1,2,3,4,5,6,7,8,9};
        for (int i = 8; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        return a;
    }

    // Print board clearly
    private static void print(int[][] board) {
        for (int r = 0; r < big; r++) {
            if (r % 3 == 0) {
                System.out.println("+-------+-------+-------+");
            }
            for (int c = 0; c < big; c++) {
                if (c % 3 == 0) System.out.print("| ");
                System.out.print(board[r][c] + " ");
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+");
    }
}
