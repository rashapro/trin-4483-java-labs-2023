package rinthaisong.trin.lab3;

/**
 * Number Guessing Method Game Progarm :
 * This program works like Number Guessing Game Program
 * But this program have two subroutines, namely genAnswer() and playGame()
 * Each subroutine has a different function.
 * To make the program more clearly.
 * 
 * Author : Trin Rinthaisong
 * ID : 653040448-3
 * Sec : 2
 * Date : 8/12/2023
 */
import java.util.*;

public class NumberGuessingMethodGame {
    static int answer; // กำหนดตัวแปรแทนคำตอบ
    final static int MIN = 1; // final เพื่อล็อคค่า(ไม่สามารถเปลี่ยนค่าได้)
    final static int MAX = 20;

    static void genAnswer() { // subroutineนี้ใช้แทนการคำนวณการสุ่มคำตอบ
        answer = (int) (Math.random() * 20 - 1) + 1;
    }

    static void playGame() { // subroutineนี้ใช้แทนการทำงานของเกมโดยใช้โค้ดจาก Number Guessing Game Program
        Scanner scanner = new Scanner(System.in);
        int numberOfTries = 0;
        int maxTries = 5;

        System.out.println("Welcome to a number guessing game!");
        System.out.print("Enter an integer between 1 and 20:");

        while (numberOfTries < maxTries) {
            int guess = scanner.nextInt();
            numberOfTries++;
            if (numberOfTries == 5) {
                if (guess == answer) {

                } else {
                    System.out.println("You have tried 5 times. You ran out of guesses");
                    System.out.println("The answer is " + answer);
                    break;
                }
            }

            if (guess == answer) {
                if (numberOfTries == 1) {
                    System.out.println("Congratulations!");
                    System.out.println("You have tried 1 time");
                    break;
                } else {
                    System.out.println("Congratulations!");
                    System.out.println("You have tried " + numberOfTries + " times");
                    break;
                }

            } else if (guess > answer) {
                System.out.println("Try a lower number!");
                System.out.print("Enter an integer between 1 and 20:");

            } else {
                System.out.println("Try a higher number!");
                System.out.print("Enter an integer between 1 and 20:");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) { // methodนี้ใช้รวมsubroutineทั้งสองเพื่อให้โปรแกรมทำงาน
        genAnswer();
        playGame();
    }
}