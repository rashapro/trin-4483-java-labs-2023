package rinthaisong.trin.lab3;

/**
 * Number Guessing Game Progarm :
 * This program will generate random numbers between 1-20.
 * And the program will let you guess the number.
 * You have 5 chances to guess the number correctly.
 * 
 * Author : Trin Rinthaisong
 * ID : 653040448-3
 * Sec : 2
 * Date : 8/12/2023
 */
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answer = (int) (Math.random() * 20 - 1) + 1; // สมการใช้สุ่มตัวเลข
        int numberOfTries = 0;
        int maxTries = 5;
        System.out.println(answer);// ผลเฉลยเพื่อเอาไว้เช็คว่าโปรแกรมถูกต้อง
        System.out.println("Welcome to a number guessing game!");
        System.out.print("Enter an integer between 1 and 20:");

        while (numberOfTries < maxTries) { // loop ทำงานเมื่อ จำนวนครั้งที่ลองเดา น้อยกว่าจำนวนครั้งที่ให้ลอง(5ครั้ง)
            int guess = scanner.nextInt();

            numberOfTries++;
            if (numberOfTries == 5) { // เงื่อนไขนี้ทำงานเมื่อจำนวนครั้งที่ลองครบ5ครั้ง
                if (guess == answer) {

                } else {
                    System.out.println("You have tried 5 times. You ran out of guesses");
                    System.out.println("The answer is " + answer);
                    break;
                }
            }

            if (guess == answer) { // เงื่อนไขนี้ทำงานเมื่อเดาตัวเลขถูก
                if (numberOfTries == 1) { // เฉพาะกรณีที่เดาถูกภายใน 1ครั้ง
                    System.out.println("Congratulations!");
                    System.out.println("You have tried 1 time");
                    break;
                } else {
                    System.out.println("Congratulations!");
                    System.out.println("You have tried " + numberOfTries + " times");
                    break;
                }

            } else if (guess > answer) { // เงื่อนไขนี้ถูกใช้งานเมื่อเดาตัวเลขสูงกว่าคำตอบ
                System.out.println("Try a lower number!");
                System.out.print("Enter an integer between 1 and 20:");

            } else { // เงื่อนไขนี้ถูกใช้งานเมื่อเดาตัวเลขต่ำกว่าคำตอบ
                System.out.println("Try a higher number!");
                System.out.print("Enter an integer between 1 and 20:");
            }
        }
        scanner.close();
    }
}