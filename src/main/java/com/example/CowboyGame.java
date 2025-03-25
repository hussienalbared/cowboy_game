package com.example;

public class CowboyGame {
   

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java CircleOfPeopleGame <number_of_people>");
            return;
        }

        int numPeople = parseInput(args[0]);
        if (numPeople < 2) {
            System.out.println("Error: Number of people must be at least 2.");
            return;
        }

        Game game = new Game(numPeople);
        game.start();
    }

    private static int parseInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format.");
            return -1;
        }
    }
}
