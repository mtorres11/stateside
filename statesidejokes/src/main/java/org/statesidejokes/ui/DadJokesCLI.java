package org.statesidejokes.ui;

import org.statesidejokes.wrapperapi.DadJokes;
import org.statesidejokes.wrapperapi.DadJokesSync;

import java.util.Scanner;

public class DadJokesCLI {

    public static void main(String[] args) {
        DadJokes dadJokes = new DadJokesSync();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Get Random Joke");
            System.out.println("2. Get Joke Count");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    String randomJoke = dadJokes.getRandomJoke();
                    System.out.println("Random Joke: " + randomJoke);
                }
                case 2 -> {
                    int jokeCount = dadJokes.getJokeCount();
                    System.out.println("Joke Count: " + jokeCount);
                }
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}

