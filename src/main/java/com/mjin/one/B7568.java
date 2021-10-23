package com.mjin.one;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class B7568 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int personCount = Integer.parseInt(br.readLine());
        List<Person> persons = new ArrayList<>();
        List<Integer> ranks = new ArrayList<>();

        for (int i = 0; i < personCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            persons.add(new Person(height, weight));
        }

        for (int i = 0; i < personCount; i++) {
            int biggerCount = 1;

            for (int j = 0; j < personCount; j++) {
                if (i == j) {
                    continue;
                }

                if (persons.get(i).compare(persons.get(j)) == -1) {
                    biggerCount++;
                }
            }

            ranks.add(biggerCount);
        }

        System.out.println(ranks.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}

class Person {

    private final int height;
    private final int weight;

    public Person(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int compare(Person p) {
        if (this.height > p.height && this.weight > p.weight) {
            return 1;
        } else if (this.height < p.height && this.weight < p.weight) {
            return -1;
        } else {
            return 0;
        }
    }
}
