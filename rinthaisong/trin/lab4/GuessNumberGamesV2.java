package rinthaisong.trin.lab4;

import java.util.Scanner;

public class GuessNumberGamesV2 {
    static int answer, min, max, numberOfTries, maxTries, guess, validGuessesCount; // กำหนดตัวแปรใหม่เพื่อแทนจำนวนสมาชิกใน
                                                                                    // Array
    static String playAgain;
    static Scanner input = new Scanner(System.in);
    static int[] guesses;

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
                    guesses[validGuessesCount] = guess; // เก็บค่าเข้าไปใน Array
                    validGuessesCount++; // เพิ่มจำนวนสมาชิกใน Array
                } else {
                    System.out.println("You have tried " + maxTries + " times. You ran out of guesses");
                    System.out.println("The answer is " + answer);
                    break;
                }
            }

            if (guess == answer) {
                if (numberOfTries == 1) {
                    guesses[validGuessesCount] = guess; // เก็บค่าเข้าไปใน Array
                    validGuessesCount++; // เพิ่มจำนวนสมาชิกใน Array
                    System.out.println("Congratulations!");
                    System.out.println("You have tried 1 time");
                    break;
                } else {
                    System.out.println("Congratulations!");
                    System.out.println("You have tried " + numberOfTries + " times");
                    break;
                }

            } else if (guess > answer) {
                guesses[validGuessesCount] = guess; // เก็บค่าเข้าไปใน Array
                validGuessesCount++; // เพิ่มจำนวนสมาชิกใน Array
                System.out.println("Try a lower number!");
                System.out.print("Enter an integer between " + min + " and " + max + " :");

            } else {
                guesses[validGuessesCount] = guess; // เก็บค่าเข้าไปใน Array
                validGuessesCount++; // เพิ่มจำนวนสมาชิกใน Array
                System.out.println("Try a higher number!");
                System.out.print("Enter an integer between " + min + " and " + max + " :");
            }
        }
        boolean review = true; // กำหนดตัวแปร boolean เพื่อใช้เป็นเงื่อนไข
        while (review) {
            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any others key to quit: ");
            char option = input.next().charAt(0); // รับค่า Input

            if (option == 'a') { // แสดงค่าที่เก็บไว้ใน Array ทั้งหมด
                System.out.println("All guesses: ");
                for (int i = 0; i < validGuessesCount; i++) {
                    System.out.print(guesses[i] + " ");
                }
                System.out.print("\n");
            } else if (option == 'g') { // แสดงค่าใน Array ตามที่ต้องการ
                System.out.print("Enter the guess number to view (1 to " + numberOfTries + "): ");
                int guessNumber = input.nextInt();
                if (guessNumber > 0 || guessNumber <= validGuessesCount) {
                    System.out.println("Guess " + guessNumber + ": " + guesses[guessNumber - 1]);
                }
            } else {
                review = false;
            }
        }

        System.out.print("Want to play again (Y or y): "); // แสดงข้อความเพื่อให้เลือกว่าจะเล่นต่อหรือไม่
        playAgain = input.next();
        playAgain.toLowerCase(); // แปลงค่า playAgain เป็นตัวพิมพ์เล็ก
        if (playAgain.equalsIgnoreCase("Y")) { // เปรียบเทียบค่า playAgain ว่าเท่ากับ "y" หรือไม่
            genAnswer();
            playGame();
        } else {
            System.out.println("Thank you for playing our game. Bye!");
        }
        input.close();
    }

    public static void main(String[] args) { // methodนี้ใช้รวมsubroutineทั้งสามเพื่อให้โปรแกรมทำงาน
        configure();
        genAnswer();
        playGame();
    }
}