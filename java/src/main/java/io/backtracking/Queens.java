package io.backtracking;

public class Queens {
    public static final int SIZE = 8;
    int[][] board = new int[SIZE][SIZE];

    public static void main(String... args) {
        Queens queens = new Queens();
        queens.place(8);
        queens.print();
    }

    void place(int queens) {
        if (queens == 0) return;
        Position p = availablePosition();
        // full
        if (p == null) {
            return;
        }
        boolean placed = placeQueen(p);
        if (placed) {
            place(queens - 1);
        } else {
            // backtrack
            place(queens);
        }
    }

    void print() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j]);
                if (j == SIZE - 1) System.out.println("");
            }
        }
    }

    private boolean placeQueen(Position p) {
        boolean placed = true;
        for (int k = 0; k < SIZE; k++) {
            if (board[p.i][k] == 1) placed = false;
            if (board[k][p.j] == 1) placed = false;
        }
        for (int k = 0; p.i - k >= 0 && p.j - k >= 0; k++) {
            if (board[p.i - k][p.j - k] == 1) placed = false;
        }

        for (int k = 0; p.i + k < SIZE && p.j + k < SIZE; k++) {
            if (board[p.i + k][p.j + k] == 1) placed = false;
        }

        for (int k = 0; p.i - k >= 0 && p.j + k < SIZE; k++) {
            if (board[p.i - k][p.j + k] == 1) placed = false;
        }

        for (int k = 0; p.i + k < SIZE && p.j - k >= 0; k++) {
            if (board[p.i + k][p.j - k] == 1) placed = false;
        }
        if (placed) {
            board[p.i][p.j] = 1;
        } else {
            board[p.i][p.j] = 2;
        }

        return placed;
    }

    private Position availablePosition() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) return new Position(i, j);
            }
        }
        return null;
    }
}
