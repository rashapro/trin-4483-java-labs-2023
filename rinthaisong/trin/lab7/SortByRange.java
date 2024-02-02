package rinthaisong.trin.lab7;

/**
 * This program is SortByRange
 * This program implements Comparator<GuessNumberGameVer4>
 * This program is for sort random range
 * Author: Trin Rinthaisong
 * ID: 653040448-3
 * Sec: 2
 * Date: 1/2/2024
 *
 **/

import java.util.Comparator;

public class SortByRange implements Comparator<GuessNumberGameVer4> {

    @Override
    public int compare(GuessNumberGameVer4 o1, GuessNumberGameVer4 o2) {
        return (o2.getMaxNum() - o2.getMinNum()) - (o1.getMaxNum() - o1.getMinNum());
    }
}