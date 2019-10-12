package com.company;

import java.io.File;
import java.io.IOException;

public class SolidusQuestion2 {

    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            throw new IllegalArgumentException("Please provide 2 parameters in the following format:" +
                    "[File name containing prices list] [Gift card balance]");
        }

        File file = ArgumentParser.parseFile(args[0]);
        Integer giftCardBalance = ArgumentParser.parseBalance(args[1]);
        PairFinder pairFinder = new PairFinder();
        pairFinder.findClosestPair(file, giftCardBalance);
    }
}
