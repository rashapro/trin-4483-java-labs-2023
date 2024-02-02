package rinthaisong.trin.lab7;

/**
 * This program is TestGamesProb1
 * Class TestGamesProb which inherited from GuessNumberGameVer4.
 * This program is for test comparing max tries.
 * Author: Trin Rinthaisong
 * ID: 653040448-3
 * Sec: 2
 * Date: 1/2/2024
 *
 **/

import java.util.ArrayList;
import java.util.Collections;

public class TestGamesProb1 extends GuessNumberGameVer4 {
    static ArrayList<GuessNumberGameVer4> games = new ArrayList<GuessNumberGameVer4>(); // ArrayList

    public static void initGamesList() {
        games.add(new GuessNumberGameVer4(1, 10, 7));
        games.add(new GuessNumberGameVer4(1, 10, 5));
        games.add(new GuessNumberGameVer4(1, 5, 5));
        // ส่งค่าพารามิเตอร์ไปยัง GuessNumberGameVer4();
        System.out.println("===== Unsorted games list: =====");
        for (GuessNumberGameVer4 game : games) {
            System.out.println(game);
        } // แสดงค่าที่ยังไม่เรียงลำดับ
    }

    public static void sortGamesList() {
        Collections.sort(games, new SortByMaxTries()); // เรียกใช้คลาส SortByMaxTries
        System.out.println("===== Sorted games list: =====");
        for (GuessNumberGameVer4 game : games) {
            System.out.println(game);
        } // แสดงค่าที่เรียงลำดับโดยจำนวนการเดาสูงสุด
    }

    public TestGamesProb1(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = maxTries;
    }

    public static void main(String[] args) {
        initGamesList();
        sortGamesList();
    }
}