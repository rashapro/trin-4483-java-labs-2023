package rinthaisong.trin.lab3;

/**
 * Number Guessing Games Progarm :
 * This program works like Configurable Number Guessing Game Progarm.
 * But this program can check if the values ​​do not match the conditions.
 * and can play again if you type "Y" or "y"
 * 
 * Author : Trin Rinthaisong
 * ID : 653040448-3
 * Sec : 2
 * Date : 8/12/2023
 */
import java.util.Scanner;

public class NumberGuessingGames {
    static int answer, min, max, numberOfTries, maxTries;
    static String playAgain; // กำหนดตัวแปลไว้รับค่าString
    static Scanner input = new Scanner(System.in);

    static void configure() { // subroutineนี้ใช้เพื่อกำหนดคว่า min, max และ maxTries
        System.out.print("Enter the min value : ");
        min = input.nextInt();
        System.out.print("Enter the max value : ");
        max = input.nextInt();
        if (max < min) { // หากกำหนดค่า max น้อยกว่าค่า min เงื่อนไขจะถูกทำงาน
            while (max < min) {
                System.out.println("The max value must be at least equal to the min value."); // แสดงข้อความเตือน
                System.out.print("Enter the max value : "); // และให้ป้อนค่า max อีกรอบจนกว่าจะตรงเงื่อนไข
                max = input.nextInt();
            }
        }
        System.out.print("Enter the maximum number of tried : ");
        maxTries = input.nextInt();
        if (maxTries <= 0) { // หากกำหนดค่า maxTried น้อยกว่าหรือเท่า 0 เงื่อนไขจะถูกทำงาน
            while (maxTries <= 0) {
                System.out.println("The maximum number of tries must be greater than 0"); // แสดงข้อความเตือน
                System.out.print("Enter the maximum number of tried : "); // และให้ป้อนค่า maxTried
                                                                          // อีกรอบจนกว่าจะตรงเงื่อนไข
                maxTries = input.nextInt();
            }
        }
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
            if (guess < min || guess > max) {
                System.out.println("The number must be between " + min + " and " + max);
                System.out.print("Enter an integer between " + min + " and " + max + " :");
                continue;
            }
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
        System.out.print("Want to play again (Y or y): "); // แสดงข้อความเพื่อให้เลือกว่าจะเล่นต่อหรือไม่
        playAgain = input.next();
        playAgain.toLowerCase();// แปลงค่า playAgain เป็นตัวพิมพ์เล็ก
        if (playAgain.equalsIgnoreCase("y")) { // เปรียบเทียบค่า playAgain ว่าเท่ากับ "y" หรือไม่
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