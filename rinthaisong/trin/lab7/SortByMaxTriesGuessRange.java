package rinthaisong.trin.lab7;

/**
 * This program is SortByMaxTriesThenRandomRange
 * This program implements Comparator<GuessNumberGameVer4>
 * This program is for sort max tries then sort random range
 * Author: Trin Rinthaisong
 * ID: 653040448-3
 * Sec: 2
 * Date: 1/2/2024
 *
 **/

import java.util.Comparator;

public class SortByMaxTriesGuessRange implements Comparator<GuessNumberGameVer4> {

    @Override
    public int compare(GuessNumberGameVer4 o1, GuessNumberGameVer4 o2) {
        int maxTriesCompare = new SortByMaxTries().compare(o1, o2); // เรียกใช้คลาส SortByMaxTries
        int maxNumCompare = new SortByRange().compare(o1, o2); //// เรียกใช้คลาส SortByRange
        if (maxTriesCompare == 0) {
            return ((maxNumCompare == 0) ? maxTriesCompare : maxNumCompare); // ถ้า maxTries
                                                                             // มีค่าเท่ากันให้ทำเงื่อนไขนี้
        } else {
            return o1.getMaxTries() - o2.getMaxTries();
        }
    }
}