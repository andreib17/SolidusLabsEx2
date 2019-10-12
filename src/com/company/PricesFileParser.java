package com.company;

import javafx.util.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class PricesFileParser {

    /**
     * parse the prices file to a list of pairs, first element is the name, second is the price
     */
    static List<Pair<String, Integer>> parseFile(File file) throws IOException {
        FileInputStream fstream = new FileInputStream(file);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;

        List<Pair<String, Integer>> itemsList = new ArrayList<>();
        while ((strLine = br.readLine()) != null) {
            String[] itemArr = strLine.split(",");
            Pair<String, Integer> pair = new Pair<>(itemArr[0].trim(), Integer.valueOf(itemArr[1].trim()));
            itemsList.add(pair);
        }
        return itemsList;
    }
}
