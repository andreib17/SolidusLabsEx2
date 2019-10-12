package com.company;

import java.io.File;

class ArgumentParser {

    /**
     * make sure the given path is of an actual file
     */
    static File parseFile(String pathStr) {
        File file = new File(pathStr);
        if (file.isFile()) {
            return file;
        }

        throw new IllegalArgumentException(String.format("Invalid file %s", pathStr));
    }

    /**
     * validate the given gift card balance amount
     */
    static Integer parseBalance(String balanceStr) {
        Integer balance = Integer.valueOf(balanceStr);
        if (balance > 0) {
            return balance;
        }

        throw new IllegalArgumentException(String.format("Invalid gift card balance amount %s", balance));
    }
}
