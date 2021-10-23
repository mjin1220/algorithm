package com.mjin.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2447 {

    private static final int[][] RELATIVE_STAR_POSITIONS = {
            {0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 2},
            {2, 0}, {2, 1}, {2, 2}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[][] board = new boolean[N][N];
        writeStars(board, new Point(0, 0), N);

        StringBuffer sb = new StringBuffer(N * (N + 1));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j] ? "*" : " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void writeStars(boolean[][] board, Point startPoint, int lineSize) {
        if (lineSize == 3) {
            for (int[] relativeStarPosition : RELATIVE_STAR_POSITIONS) {
                board[startPoint.getY() + relativeStarPosition[0]][startPoint.getX() + relativeStarPosition[1]] = true;
            }
            return;
        }

        int nextLineSize = lineSize / 3;
        for (int[] relativeStarPosition : RELATIVE_STAR_POSITIONS) {
            Point newStartPoint = new Point(startPoint.getX() + relativeStarPosition[0] * nextLineSize,
                    startPoint.getY() + relativeStarPosition[1] * nextLineSize);
            writeStars(board, newStartPoint, nextLineSize);
        }
    }
}

class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}