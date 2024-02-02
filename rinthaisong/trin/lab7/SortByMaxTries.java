package rinthaisong.trin.lab7;

/**
 * This program is SortByMaxTries
 * This program implements Comparator<GuessNumberGameVer4>
 * This program is for sort max tries.
 * Author: Trin Rinthaisong
 * ID: 653040448-3
 * Sec: 2
 * Date: 1/2/2024
 *
 **/

import java.util.Comparator;

public class SortByMaxTries implements Comparator<GuessNumberGameVer4> {
    @Override
    public int compare(GuessNumberGameVer4 o1, GuessNumberGameVer4 o2) {
        return o1.getMaxTries() - o2.getMaxTries();
    }
}