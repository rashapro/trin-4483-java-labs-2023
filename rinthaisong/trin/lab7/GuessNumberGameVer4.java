package rinthaisong.trin.lab7;

/**
 * This program is GuessNumberGameVer4
 * Class GuessNumberGameVer4 which inherited from GuessNumberGameVer3.
 * The program will display nimimum number ,maximum nuber and maximum of tries number
 * Author: Trin Rinthaisong
 * ID: 653040448-3
 * Sec: 2
 * Date: 1/2/2024
 *
 **/

import rinthaisong.trin.lab5.*;
import java.util.ArrayList;

public class GuessNumberGameVer4 extends GuessNumberGameVer3 {
    static ArrayList<GuessNumberGameVer4> games = new ArrayList<GuessNumberGameVer4>(); // ArrayList

    public static void initGamesList() {
        games.add(new GuessNumberGameVer4(1, 10, 3));
        games.add(new GuessNumberGameVer4(1, 10, 5));
        games.add(new GuessNumberGameVer4(1, 5, 5));
        // ส่งค่าพารามิเตอร์ไปยัง GuessNumberGameVer4();
        System.out.println("TestGuessNumberGameVer4");
        for (GuessNumberGameVer4 game : games) {

            System.out.println(game);
        } // แสดงค่าที่ยังไม่เรียงลำดับ
    }

    public GuessNumberGameVer4(int minNum, int maxNum, int maxTries) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = maxTries;
    }

    @Override
    public String toString() {
        return "GuessNumberGameVer4 (min:" + minNum + ", max:" + maxNum + ", max tries:" + maxTries + ")";
    }

    public static void main(String[] args) {
        initGamesList();
    }
}