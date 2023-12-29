package rinthaisong.trin.lab4;

import java.util.Scanner;

public class GuessNumberGamesV3 {
    static int answer, min, max, numberOfTries, maxTries, guess, validGuessesCount;
    static String playAgain, winOrLose; // กำหนดตัวแปรเพื่อรับค่าแพ้/ชนะ
    static Scanner input = new Scanner(System.in);
    static int[] guesses;
    static int totalGames, wins, totalGuesses; // กำหนดตัวแปรเพื่อรับค่าสถิติต่างๆของเกม
    static int highScore = Integer.MIN_VALUE; // กำหนดเพื่อรับค่า guess ที่น้อยที่สุด

    static void configure() { // subroutineนี้ใช้เพื่อกำหนดคว่า min, max และ maxTries
        System.out.print("Enter the min value : ");
        min = input.nextInt();
        System.out.print("Enter the max value : ");
        max = input.nextInt();
        if (max < min) {
            while (max < min) {
                System.out.println("The max value must be at least equal to the min value.");
                System.out.print("Enter the max value : ");
                max = input.nextInt();
            }
        }
        System.out.print("Enter the maximum number of tried : ");
        maxTries = input.nextInt();
        if (maxTries <= 0) {
            while (maxTries <= 0) {
                System.out.println("The maximum number of tries must be greater than 0");
                System.out.print("Enter the maximum number of tried : ");
                maxTries = input.nextInt();
            }
        }
    }

    static void genAnswer() {
        answer = (int) (Math.random() * (max - min + 1)) + min;
        System.out.println(answer);// ผลเฉลยเพื่อเอาไว้เช็คว่าโปรแกรมถูกต้อง
    }

    static void playGame() { // subroutine playGame() มีการแก้ไข
        guesses = new int[maxTries];
        validGuessesCount = 0;
        int numberOfTries = 0;
        System.out.println("Welcome to a number guessing game!");
        System.out.print("Enter an integer between " + min + " and " + max + " :"); // เปลี่ยนค่าmax ,min และ maxTries
                                                                                    // จากที่กำหนดไว้แล้วมาเป็นค่าที่กำหนดเอง

        while (numberOfTries < maxTries) {
            guess = input.nextInt();
            if (guess < min || guess > max) {
                System.out.print("your guess should be in [" + min + "," + max + "]:");
                continue;
            }
            numberOfTries++;
            if (numberOfTries == maxTries) {
                if (guess == answer) {
                    guesses[validGuessesCount] = guess;
                    validGuessesCount++;
                } else {
                    System.out.println("You have tried " + maxTries + " times. You ran out of guesses");
                    System.out.println("The answer is " + answer);
                    break;
                }
            }

            if (guess == answer) {
                if (numberOfTries == 1) {
                    guesses[validGuessesCount] = guess;
                    validGuessesCount++;
                    System.out.println("Congratulations!");
                    System.out.println("You have tried 1 time");
                    wins++; // เมื่อทายถูกค่า wins จะเพิ่มขึ้นทีละ 1
                    highScore = numberOfTries; // เก็บค่าจำนวนครั้งที่ทายเพื่อเอาค่าที่น้อยที่สุดไปแสดงผล
                    break;
                } else {
                    System.out.println("Congratulations!");
                    System.out.println("You have tried " + numberOfTries + " times");
                    wins++; // เมื่อทายถูกค่า wins จะเพิ่มขึ้นทีละ 1
                    highScore = numberOfTries; // เก็บค่าจำนวนครั้งที่ทายเพื่อเอาค่าที่น้อยที่สุดไปแสดงผล
                    break;
                }

            } else if (guess > answer) {
                guesses[validGuessesCount] = guess;
                validGuessesCount++;
                System.out.println("Try a lower number!");
                System.out.print("Enter an integer between " + min + " and " + max + " :");

            } else {
                guesses[validGuessesCount] = guess;
                validGuessesCount++;
                System.out.println("Try a higher number!");
                System.out.print("Enter an integer between " + min + " and " + max + " :");
            }
        }
        totalGames++; // เพื่มจำนวนเกมที่เล่นตามจำนวนครั้งที่เริ่มเล่นใหม่
        totalGuesses += validGuessesCount;// เพิ่มจำนวนครั้งที่ทายตามจำนวนค่าใน Array
        boolean review = true;
        while (review) {
            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any others key to quit: ");
            char option = input.next().charAt(0);

            if (option == 'a') {
                System.out.println("All guesses: ");
                for (int i = 0; i < validGuessesCount; i++) {
                    System.out.print(guesses[i] + " ");
                }
                System.out.print("\n");
            } else if (option == 'g') {
                System.out.print("Enter the guess number to view (1 to " + numberOfTries + "): ");
                int guessNumber = input.nextInt();
                if (guessNumber > 0 || guessNumber <= validGuessesCount) {
                    System.out.println("Guess " + guessNumber + ": " + guesses[guessNumber - 1]);
                }
            } else {
                review = false;
            }
        }
        if (guess == answer) { // เมื่อทายถูกให้แสดงว่า true
            winOrLose = "true";
        } else {
            winOrLose = "false"; // เมื่อทายผิดให้แสดงว่า false
        }
        System.out.println("Game Log: Answer: " + answer + ", Guesses: " + guesses.length + ", Win: " + winOrLose);

        System.out.print("Want to play again (Y or y): ");
        playAgain = input.next();
        playAgain.toLowerCase();
        if (playAgain.equalsIgnoreCase("Y")) {
            genAnswer();
            playGame();
        } else {
            System.out.println("Thank you for playing our game. Bye!");
        }
        input.close();
    }

    static void gameStatistics() { // subroutine ที่ใช้คำนวณและแสดงผลสถิติต่างๆ
        System.out.println("---- Game Statistics -----");
        System.out.println("Total games played: " + totalGames);
        System.out.println("Total Wins: " + wins);

        if (totalGames > 0) { // ถ้าจำนวนเกมที่เล่นมากกว่า0 ให้แสดงผลตามนี้
            System.out.println("Win Ratio: " + ((double) wins / totalGames * 100) + "%"); // หาอัตราการชนะ
            System.out.println("Average Guesses per Game: " + ((double) totalGuesses / totalGames)); // หาค่าเฉลี่ยของจำนวนครั้งที่ทายในแต่ละเกม

            if (highScore == Integer.MIN_VALUE) { // ถ้า highScore เท่ากับจำนวนที่น้อยที่สุดให้แสดงผลตามนี้
                System.out.println("High Score (Least Guesses): " + highScore);
            } else {
                System.out.println("High Score (Least Guesses): N/A");
            }
        } else { // ถ้าจำนวนเกมที่เล่นเท่ากับา0 ให้แสดงผลตามนี้
            System.out.println("Win Ratio: 0.0%");
            System.out.println("High Score (Least Guesses): N/A");
        }
    }

    public static void main(String[] args) { // methodนี้ใช้รวมsubroutineทั้งสี่เพื่อให้โปรแกรมทำงาน
        configure();
        genAnswer();
        playGame();
        gameStatistics(); // subroutine ใหม่ที่เพิ่มเข้ามา
    }
}