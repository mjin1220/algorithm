package com.mjin.one;

import java.util.List;

public class B10171 {

    public static void main(String[] args) {
        final List<String> outputs = List.of(
                "\\    /\\",
                " )  ( ')",
                "(  /  )",
                " \\(__)|"
        );
        outputs.forEach(System.out::println);
    }
}
