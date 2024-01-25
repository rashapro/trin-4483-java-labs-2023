package rinthaisong.trin.lab5;

import java.util.Scanner;

public class GuessNumberGameVer3 extends GuessNumberGameVer2 {
    // constructors ที่ใช้เรียก constructors ของ GuessNumberGameVer2
    public GuessNumberGameVer3() {
        super();
    }

    public GuessNumberGameVer3(int minNum, int maxNum) {
        super(minNum, maxNum);
    }

    public GuessNumberGameVer3(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    public void guessAverage() { // method ที่ใช้เฉลี่ยค่า guess ทั้งหมด
        if (numGuesses == 0) {

        } else {
            int sum = 0;
            for (int i = 0; i < numGuesses; i++) {
                sum += guesses[i];
            }
            double average = (double) sum / numGuesses;
            System.out.println("Average = " + average);
        }
    }

    public void guessMin() { // method ที่ใช้หาค่า guess ที่น้อยที่สุด
        if (numGuesses == 0) {

        } else {
            int min = guesses[0];
            for (int i = 1; i < numGuesses; i++) {
                if (guesses[i] < min) {
                    min = guesses[i];
                }
            }
            System.out.println("Min = " + min);
        }
    }

    public void guessMax() { // method ที่ใช้หาค่า guess ที่มากที่สุด
        if (numGuesses == 0) {

        } else {
            int max = guesses[0];
            for (int i = 1; i < numGuesses; i++) {
                if (guesses[i] > max) {
                    max = guesses[i];
                }
            }
            System.out.println("Max = " + max);
        }
    }

    @Override
    public void playGames() { // method ใช้ดำเนินการเล่นเกม มีการเปลี่ยนแปลง
        Scanner scanner = new Scanner(System.in);
        char choice;
        playGame();

        do {
            System.out.println('\n' + "If you want to play again, type 'y' to continue or 'q' to quit:");
            System.out.println("Type 'a' to see all your guesses, 'g' to see a guess on specific play,");
            System.out.println(
                    "Type 'v' to show the average of the guesses, 'm' to show the minimum of the guesses, or 'x' show the maximum of the guesses");

            choice = scanner.next().charAt(0);

            switch (Character.toLowerCase(choice)) {
                case 'g':
                    showSpecific();
                    break;
                case 'a':
                    showGuesses();
                    break;
                case 'v':
                    guessAverage();
                    break;
                case 'm':
                    guessMin();
                    break;
                case 'x':
                    guessMax();
                    break;
                case 'q':
                    System.out.println("Quitting the game.");
                    break;
                case 'y':
                    playGame();
                    break;
                default:
                    System.out.println("Invalid command");
            }

        } while (choice != 'q');
    }
}