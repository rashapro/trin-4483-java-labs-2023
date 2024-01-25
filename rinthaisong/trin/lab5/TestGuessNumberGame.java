package rinthaisong.trin.lab5;

public class TestGuessNumberGame {
    public static void testPart1() { // กำหนดค่าต่างๆและใช้แสดงผล
        GuessNumberGameVer1 gng1 = new GuessNumberGameVer1();
        gng1.playGame();
        System.out.println("There are " + GuessNumberGameVer1.getNumOfGames() + " games");
        gng1.setMinNum(2);
        gng1.setMaxNum(5);
        gng1.setMaxTries(2);
        System.out.println(
                "Min = " + gng1.getMinNum() + " Max = " + gng1.getMaxNum() + " Max tries = " + gng1.getMaxTries());
        gng1.playGame();
        GuessNumberGameVer1 gng2 = new GuessNumberGameVer1();
        System.out.println(
                "Min = " + gng2.getMinNum() + " Max = " + gng2.getMaxNum() + " Max tries = " + gng2.getMaxTries());
        System.out.println("There are " + GuessNumberGameVer1.getNumOfGames() + " games");
    }

    public static void testConstructors() { // กำหนดค่าต่างๆและใช้แสดงผล
        GuessNumberGameVer1 gng1 = new GuessNumberGameVer1();
        GuessNumberGameVer1 gng2 = new GuessNumberGameVer1(5, 10);
        GuessNumberGameVer1 gng3 = new GuessNumberGameVer1(10, 20, 5);
        System.out.println(gng1);
        gng1.playGame();
        System.out.println(gng2);
        gng2.playGame();
        System.out.println(gng3);
        gng3.playGame();
    }

    public static void testGames() { // กำหนดค่าต่างๆและใช้แสดงผล
        GuessNumberGameVer2 gng = new GuessNumberGameVer2(5, 10, 4);
        gng.playGames();
    }

    public static void testPlayGameStats() { // กำหนดค่าต่างๆและใช้แสดงผล
        GuessNumberGameVer3 gng = new GuessNumberGameVer3(1, 5, 3);
        System.out.println(gng);
        gng.playGames();
    }

    public static void main(String[] args) {
        // testPart1();
        // testConstructors();
        // testGames();
        testPlayGameStats();
    }
}