package com.haldes.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ImplementStack {

    public static List<Integer> execute(List<String> program) {
        System.out.println(program);

        List<Integer> stack = new ArrayList<>();
        for (String input : program) {
            if (input.equals("peek")) {
                System.out.println(stack.get(stack.size() - 1));
            } else if (input.equals("pop")) {
                stack.remove(stack.size() - 1);
            } else if (input.contains("push")) {
                Integer val = Integer.parseInt(input.split(" ")[1].trim());
                stack.add(val);
            } else {
                System.out.println("Invalid command");
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int programLength = Integer.parseInt(scanner.nextLine());
        List<String> program = new ArrayList<>();
        for (int i = 0; i < programLength; i++) {
            program.add(scanner.nextLine());
        }
        scanner.close();
        List<Integer> res = execute(program);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
