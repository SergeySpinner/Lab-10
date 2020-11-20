package com.jetbrains;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CircledQueue<Character> test = new CircledQueue<>(5);
        test.put('a');

        test.put('b');

        ArrayList<Character> array = new ArrayList<>();

        array.add('A');
        array.add('r');
        array.add('r');
        array.add('a');
        array.add('y');

        System.out.println(array.size());

        CircledQueue<Character> test2 = new CircledQueue<>(3);

        test2.put('f');
        test2.put('G');
        test2.put('a');

        CircledQueue<Character> testGroup = new CircledQueue<>();
        testGroup = testGroup.group(test2, test);

        System.out.println(testGroup);

        testGroup = testGroup.add(testGroup,array);


        var ff = 3;
    }
}
