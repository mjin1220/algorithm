package com.mjin.one;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2588 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int firstNumber = Integer.parseInt(br.readLine());
        int secondNumber = Integer.parseInt(br.readLine());
        int tempNumber = secondNumber;

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            int R = tempNumber % 10;

            int subMul = firstNumber * R;
            System.out.println(subMul);
            sum += subMul * Math.pow(10, i);

            tempNumber /= 10;
        }

        System.out.println(sum);
    }
}
