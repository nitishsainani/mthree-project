package com.mthree.RandomData;

import com.mthree.SORT.Exchange;
import com.mthree.SORT.Stock;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import com.google.gson.*;

public class RandomData {
    public List<Exchange> exchanges;
    public ArrayList<String> companyNames;
    public ArrayList<String> companySymbols;

    public RandomData() {
        companyNames = new ArrayList<>(Arrays.asList(
                "Barnes Group Inc.",
                "The Boeing Company",
                "Biomerica Inc.",
                "Blue Apron Holdings Inc.",
                "Bank of America Corporation",
                "BP p.l.c.",
                "Alibaba Group Holding Limited",
                "Berkshire Hathaway Inc.",
                "BioNTech SE",
                "Agilent Technologies Inc.",
                "Apple Inc.",
                "Amazon.com Inc.",
                "Ayala Pharmaceuticals Inc.",
                "Avidity Biosciences LLC",
                "The AZEK Company Inc.",
                "ADC Therapeutics SA",
                "ARYA Sciences Acquisition Corp II",
                "Applied Molecular Transport Inc.",
                "Blue Apron Holdings Inc.",
                "Citigroup Inc.",
                "Calliditas Therapeutics AB (publ)",
                "China Liberal Education Holdings Limited",
                "Colgate-Palmolive Company",
                "Carnival Corporation & Plc",
                "Co-Diagnostics Inc.",
                "Chevron Corporation",
                "Cisco Systems Inc.",
                "The Coca-Cola Company"
        ));

        companySymbols = new ArrayList<>(Arrays.asList(
                "B",
                "BA",
                "BMRA",
                "APRN",
                "BAC",
                "BP",
                "BABA",
                "BRK-B",
                "BNTX",
                "A",
                "AAPL",
                "AMZN",
                "AYLA",
                "RNA",
                "AZEK",
                "ADCT",
                "ARYBU",
                "AMTI",
                "APRN",
                "C",
                "CALT",
                "CLEU",
                "CL",
                "CCL",
                "CODX",
                "CVX",
                "CSCO",
                "KO"
        ));

        ArrayList<String> exchangeNames = new ArrayList<>(Arrays.asList(
                "New York Stock Exchange",
                "NASDAQ",
                "Tokyo Stock Exchange",
                "Shanghai Stock Exchange",
                "Honk Kong Stock Exchange",
                "London Stock Exchange",
                "EURONEXT",
                "Shenzen Stock Exchange",
                "Toronto Stock Exchange",
                "Bombay Stock Exchange"));
        exchanges = new ArrayList<>();

        for(String exchangeName: exchangeNames) {
            exchanges.add(getExchange(exchangeName));
        }
        System.out.println(exchanges);
    }

    private Exchange getExchange(String exchangeName) {
        HashMap<String, Stock> exchangeStockMap = new HashMap<>();
        try {
            for (int i = 0; i < companySymbols.size(); ++i) {
                String symbol = companySymbols.get(i);
                String companyName = companyNames.get(i);
                exchangeStockMap.put(symbol, new Stock(symbol, companyName, getHashMapFromFile(exchangeName, symbol)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Exchange(exchangeStockMap, exchangeName);
    }

    public HashMap<String, Double> getHashMapFromFile(String exchange, String symbol) throws FileNotFoundException {
        String path = "src/main/java/com/mthree/RandomData/data/" + exchange + "/" + symbol + ".json";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        Gson gson = new Gson();
        HashMap<String, Double> json = gson.fromJson(bufferedReader, HashMap.class);
        return json;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new RandomData();
    }
}
