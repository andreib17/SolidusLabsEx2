package com.company;

import javafx.util.Pair;

import java.io.File;
import java.io.IOException;
import java.util.List;

class PairFinder {

    /**
     * O(n) complexity, go over the list of pairs from both ends,
     * check the sum relative to the gift card balance, decrease last index if the sum is greater,
     * increase the first index if the sum is less
     */
    void findClosestPair(File file, Integer giftCardBalance) throws IOException {
        List<Pair<String, Integer>> itemsList = PricesFileParser.parseFile(file);

        Integer closest = -1;
        int firstClosestIndex = 0, secondClosestIndex = 0, firstIndex = 0, lastIndex = itemsList.size() - 1;

        while (firstIndex < lastIndex) {
            //if the smaller of the two items is greater or equals to the gift card amount
            // there is no point to continue
            if (itemsList.get(firstIndex).getValue() >= giftCardBalance) {
                checkIfClosestExists(closest, itemsList, firstClosestIndex, secondClosestIndex);
            }
            Integer sum = itemsList.get(firstIndex).getValue() + itemsList.get(lastIndex).getValue();
            int comparissonResult = sum.compareTo(giftCardBalance);
            if (comparissonResult == 0) {
                System.out.println(itemsList.get(firstIndex) + ", " + itemsList.get(lastIndex));
                return;
            } else if (comparissonResult > 0) {
                --lastIndex;
            } else {
                if (sum.compareTo(closest) > 0) {
                    closest = sum;
                    firstClosestIndex = firstIndex;
                    secondClosestIndex = lastIndex;
                }
                ++firstIndex;
            }
        }

        checkIfClosestExists(closest, itemsList, firstClosestIndex, secondClosestIndex);
    }

    /**
     * check whether a close pair to the target amount exist
     */
    private void checkIfClosestExists(Integer closest, List<Pair<String, Integer>> itemsList,
                                      int firstClosestIndex, int secondClosestIndex) {
        if (closest.equals(-1)) {
            System.out.println("Not possible");
        } else {
            System.out.println(itemsList.get(firstClosestIndex) + ", " + itemsList.get(secondClosestIndex));
        }
    }
}
