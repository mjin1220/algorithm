package com.mjin.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10757
public class B10757 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            BigNumber firstNumber = new BigNumber(st.nextToken());
            BigNumber secondNumber = new BigNumber(st.nextToken());

            bw.write(add(firstNumber, secondNumber) + "\n");
        }
    }

    private static String add(BigNumber firstNumber, BigNumber secondNumber) {
        List<String> results = new ArrayList<>();

        List<Integer> firstNumbers = firstNumber.getNumbers();
        List<Integer> secondNumbers = secondNumber.getNumbers();

        int up = 0;
        for (int i = 0; i < Math.max(firstNumbers.size(), secondNumbers.size()); i++) {
            int subFirstNumber = i < firstNumbers.size() ? firstNumbers.get(i) : 0;
            int subSecondNumber = i < secondNumbers.size() ? secondNumbers.get(i) : 0;

            int sum = up + subFirstNumber + subSecondNumber;

            String sumStr = String.format("%010d", sum);
            up = Integer.parseInt(sumStr.substring(0, 1));
            sumStr = sumStr.substring(1);
            results.add(sumStr);
        }

        if (up != 0) {
            results.add(String.valueOf(up));
        }

        Collections.reverse(results);
        return removeFrontZeros(String.join("", results));
    }

    private static String removeFrontZeros(final String numberStr) {
        String tempStr = numberStr;
        while (tempStr.charAt(0) == '0' && tempStr.length() > 1) {
            tempStr = tempStr.substring(1);
        }
        return tempStr;
    }

    static class BigNumber {

        public static final int NUMBER_STR_SIZE = 9;
        private final List<Integer> numbers;

        public BigNumber(String bigNumberStr) {
            numbers = new ArrayList<>();

            String reversed = new StringBuffer(bigNumberStr).reverse()
                                                            .toString();
            for (int i = 0; i < reversed.length(); i += NUMBER_STR_SIZE) {
                String numberStr = reversed.substring(i, Math.min(reversed.length(), i + NUMBER_STR_SIZE));
                numbers.add(Integer.parseInt(new StringBuffer(numberStr).reverse()
                                                                        .toString()));
            }
        }

        public List<Integer> getNumbers() {
            return numbers;
        }
    }
}