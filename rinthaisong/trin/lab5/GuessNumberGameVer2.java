package rinthaisong.trin.lab5;

import java.util.Scanner;

public class GuessNumberGameVer2 extends GuessNumberGameVer1 {
    protected int MAX_GUESSES = 20, numGuesses, guess; // สร้างตัวแปรไว้รับค่า
    protected int[] guesses; // สร้าง array

    public GuessNumberGameVer2() { // Constructors
        super(); // เรียก constructors ของ GuessNumberGameVer1
        guesses = new int[MAX_GUESSES]; // กำหนดค่าเริ่มต้นของ array
    }

    public GuessNumberGameVer2(int minNum, int maxNum) { // Constructors ที่มีการปรับเปลี่ยน minNum และ maxNum
        super(minNum, maxNum);
        guesses = new int[MAX_GUESSES];
    }

    public GuessNumberGameVer2(int minNum, int maxNum, int maxTries) { // Constructors ที่มีการปรับเปลี่ยน minNum,
                                                                       // maxNum และ maxTries
        super(minNum, maxNum, maxTries);
        guesses = new int[MAX_GUESSES];
    }

    @Override
    public void playGame() { // method ใช้ดำเนินการเล่นเกม มีการเปลี่ยนแปลง
        Scanner scanner = new Scanner(System.in);
        int tries = 0;

        System.out.println("Welcome to a number guessing game!");
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));

        while (tries < maxTries) {
            System.out.print("Enter an integer between " + minNum + " and " + maxNum + ": ");
            int guess = scanner.nextInt();

            if (isValidGuess(guess)) { // แทนเงื่อนไขด้วย method ที่สร้างใหม่
                tries++;
                if (guess < correctNum) {
                    System.out.println("Try a higher number!");
                } else if (guess > correctNum) {
                    System.out.println("Try a lower number!");
                } else {
                    System.out.println("Congratulations!");
                    System.out.println("You have tried " + tries + " times.");
                    addGuess(guess);
                    break;
                }
            } else {
                System.out.println("Invalid guess. Please enter a number between " + minNum + " and " + maxNum + ".");
            }
        }
        if (guess != correctNum) {
            System.out.println("You have tried " + tries + " times. You ran out of guesses.");
            System.out.println("The answer is " + correctNum);
        }
    }

    boolean isValidGuess(int guess) { // method ที่ใช้ตรวจสอบค่า guess
        boolean isValid = guess >= minNum && guess <= maxNum;
        if (isValid) {
            guesses[numGuesses++] = guess;
        }
        return isValid;
    }

    public void addGuess(int guess) { // mehtod ที่ใช้เพิ่มจำนวนสมาชิกใน array
        guesses[numGuesses++] = guess;
    }

    public void showSpecific() { // method ที่ใช้แสดง guess เฉพาะค่าที่ต้องการ
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter which guess in the range (1-3)");
        int position = scanner.nextInt();
        if (position <= numGuesses) {
            System.out.println("Guess number " + position + " is " + guesses[position - 1]);
        }
    }

    public void showGuesses() { // method ที่ใช้แสดง guess ทั้งหมด
        for (int i = 0; i < numGuesses; i++) {
            System.out.print(guesses[i] + " ");
        }
    }

    public void playGames() { // method ที่ใช้แสดงผลตามตัวเลือกต่างๆที่เลือก
        Scanner scanner = new Scanner(System.in);
        char choice;
        playGame();
        do {
            System.out.println('\n' + "If want to play again? type 'y' to continue or 'q' to quit:");
            System.out.println("Type 'a' to see all your guesses or 'g' to see a guess on specific play.");
            choice = scanner.next().charAt(0);

            switch (Character.toLowerCase(choice)) {
                case 'g':
                    showSpecific();
                    break;
                case 'a':
                    showGuesses();
                    break;
                case 'q':
                    System.out.println("Quitting the game.");
                    break;
                case 'y':
                    playGame();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 'q');
    }
}