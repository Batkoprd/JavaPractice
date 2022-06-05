package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int[] heightArr = new int[] {1, 1, 3, 1, 4, 5};
        Map<String, Integer> jumpers = new LinkedHashMap<>();
        jumpers.put("John", 2);
        jumpers.put("Bob", 4);
        jumpers.put("Kate", 3);

        for (Map.Entry<String, Integer> jumper : jumpers.entrySet() ) {
            for (int height : heightArr) {
                if (jumper.getValue() <= height) {
                    System.out.println(jumper.getKey() + " can't jump so high!");
                    break;
                } else {
                    System.out.println(jumper.getKey() +  "Jump");
        }

            }
        }
    }
}
