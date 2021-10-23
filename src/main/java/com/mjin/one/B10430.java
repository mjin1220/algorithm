package com.mjin.one;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10430 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstNumber = Integer.parseInt(st.nextToken());
        int secondNumber = Integer.parseInt(st.nextToken());
        int thirdNumber = Integer.parseInt(st.nextToken());
        System.out.println((firstNumber + secondNumber) % thirdNumber);
        System.out.println(((firstNumber % thirdNumber) + (secondNumber % thirdNumber)) % thirdNumber);
        System.out.println((firstNumber * secondNumber) % thirdNumber);
        System.out.println(((firstNumber % thirdNumber) * (secondNumber % thirdNumber)) % thirdNumber);
    }
}
