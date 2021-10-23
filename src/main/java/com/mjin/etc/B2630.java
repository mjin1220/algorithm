package com.mjin.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2630 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ColorPaperResult colorPaperResult = calculateColorPaperResult(paper, N, new Point(0, 0));
        System.out.println(colorPaperResult);
    }

    private static ColorPaperResult calculateColorPaperResult(int[][] paper, int paperSize, Point startPoint) {
        if (isAllSameColor(paper, paperSize, startPoint)) {
            int colorValue = paper[startPoint.getY()][startPoint.getX()];
            if (colorValue == 0) {
                return new ColorPaperResult(1, 0);
            }
            return new ColorPaperResult(0, 1);
        }

        List<ColorPaperResult> subColorPaperResults = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int newPaperSize = paperSize / 2;
                int newX = startPoint.getX() + j * newPaperSize;
                int newY = startPoint.getY() + i * newPaperSize;
                Point newStartPoint = new Point(newX, newY);
                subColorPaperResults.add(calculateColorPaperResult(paper, newPaperSize, newStartPoint));
            }
        }

        return new ColorPaperResult(subColorPaperResults);
    }

    private static boolean isAllSameColor(int[][] paper, int paperSize, Point startPoint) {
        int firstColorValue = paper[startPoint.getY()][startPoint.getX()];

        for (int i = startPoint.getY(); i < startPoint.getY() + paperSize; i++) {
            for (int j = startPoint.getX(); j < startPoint.getX() + paperSize; j++) {
                if (firstColorValue != paper[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    static class Point {

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

    static class ColorPaperResult {

        private final int whitePaperCount;
        private final int bluePaperCount;

        public ColorPaperResult(int whitePaperCount, int bluePaperCount) {
            this.whitePaperCount = whitePaperCount;
            this.bluePaperCount = bluePaperCount;
        }

        public ColorPaperResult(List<ColorPaperResult> colorPaperResults) {
            int whitePaperCountSum = 0;
            int bluePaperCountSum = 0;

            for (ColorPaperResult colorPaperResult : colorPaperResults) {
                whitePaperCountSum += colorPaperResult.getWhitePaperCount();
                bluePaperCountSum += colorPaperResult.getBluePaperCount();
            }

            this.whitePaperCount = whitePaperCountSum;
            this.bluePaperCount = bluePaperCountSum;
        }

        public int getWhitePaperCount() {
            return whitePaperCount;
        }

        public int getBluePaperCount() {
            return bluePaperCount;
        }

        @Override
        public String toString() {
            return whitePaperCount + "\n" + bluePaperCount;
        }
    }
}