package rinthaisong.trin.lab5;

import java.util.Scanner;

public class GuessNumberGameVer1 {
    protected int minNum, maxNum, maxTries; // กำหนดตัวแปร
    protected int correctNum;
    protected static int numOfGames = 0;
    Scanner input;

    public GuessNumberGameVer1() { // Constructors
        this.minNum = 1;
        this.maxNum = 10;
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        this.maxTries = 3;
        numOfGames++;
    }

    public GuessNumberGameVer1(int minNum, int maxNum) { // Constructors ที่มีการปรับเปลี่ยน minNum และ maxNum
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        this.maxTries = 3;
        numOfGames++;
    }

    public GuessNumberGameVer1(int minNum, int maxNum, int maxTries) { // Constructors ที่มีการปรับเปลี่ยน minNum,
                                                                       // maxNum และ maxTries
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        this.maxTries = maxTries;
        numOfGames++;
    }

    public int getMinNum() { // รับค่า minNum
        return minNum;
    }

    public void setMinNum(int minNum) { // ปรับเปลี่ยนค่า minNum
        this.minNum = minNum;
    }

    public int getMaxNum() { // รับค่า maxNum
        return maxNum;
    }

    public void setMaxNum(int maxNum) { // ปรับเปลี่ยนค่า maxNum
        this.maxNum = maxNum;
    }

    public int getMaxTries() { // รับค่า MaxTries
        return maxTries;
    }

    public void setMaxTries(int maxTries) { // ปรับเปลี่ยนค่า maxTries
        this.maxTries = maxTries;
    }

    public void playGame() { // method ที่ใช้ดำเนินเกม
        Scanner scanner = new Scanner(System.in);
        int tries = 0;
        int guess = 0;
        System.out.println("Welcome to a number guessing game!");
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));

        while (tries < maxTries) {
            System.out.print("Enter an integer between " + minNum + " and " + maxNum + ":");
            guess = scanner.nextInt();
            tries++;

            if (guess < correctNum) {
                System.out.println("Try a higher number!");
            } else if (guess > correctNum) {
                System.out.println("Try a lower number!");
            } else {
                System.out.println("Congratulations!");
                System.out.println("You have tried " + tries + " times.");
                break;
            }
            System.out.println("tries = " + tries + " max tries = " + maxTries);
        }

        if (guess != correctNum) {
            System.out.println("You have tried " + tries + " times. you ran out of guesses.");
            System.out.println("The answer is " + correctNum);
        }
    }

    public static int getNumOfGames() { // method ใช้นับจำนวนเกม
        return numOfGames;
    }

    @Override // แสดงรายละเอียดสำคัญต่างๆ
    public String toString() {
        return "GuessNumberGame with min number as " + minNum + " max number as " + maxNum + " max number of tries as "
                + maxTries;
    }
}