package rinthaisong.trin.lab3;

/**
 * Configurable Number Guessing Game Progarm :
 * This program works like Number Guessing Game Program
 * But this program can customize maximum and maximum values.
 * And customize Maximum number of times to try.
 * By using subroutine namely configure().
 * 
 * Author : Trin Rinthaisong
 * ID : 653040448-3
 * Sec : 2
 * Date : 8/12/2023
 */
import java.util.*;

public class ConfigurableNumberGuessingGame {
    static int answer, min, max, numberOfTries, maxTries;
    static Scanner input = new Scanner(System.in);

    static void configure() { // subroutineนี้ใช้เพื่อกำหนดคว่า min, max และ maxTries
        System.out.print("Enter the min value : ");
        min = input.nextInt();
        System.out.print("Enter the max value : ");
        max = input.nextInt();
        System.out.print("Enter the maximum number of tried : ");
        maxTries = input.nextInt();
    }

    static void genAnswer() {
        answer = (int) (Math.random() * (max - min + 1)) + min;
        System.out.println(answer);// ผลเฉลยเพื่อเอาไว้เช็คว่าโปรแกรมถูกต้อง
    }

    static void playGame() { // subroutine playGame() มีการแก้ไข
        int numberOfTries = 0;

        System.out.println("Welcome to a number guessing game!");
        System.out.print("Enter an integer between " + min + " and " + max + " :"); // เปลี่ยนค่าmax ,min และ maxTries
                                                                                    // จากที่กำหนดไว้แล้วมาเป็นค่าที่กำหนดเอง

        while (numberOfTries < maxTries) {
            int guess = input.nextInt();
            numberOfTries++;
            if (numberOfTries == maxTries) {
                if (guess == answer) {

                } else {
                    System.out.println("You have tried " + maxTries + " times. You ran out of guesses");
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
                System.out.print("Enter an integer between " + min + " and " + max + " :");

            } else {
                System.out.println("Try a higher number!");
                System.out.print("Enter an integer between " + min + " and " + max + " :");
            }
        }
        input.close();
    }

    public static void main(String[] args) { // methodนี้ใช้รวมsubroutineทั้งสามเพื่อให้โปรแกรมทำงาน
        configure();
        genAnswer();
        playGame();
    }
}
