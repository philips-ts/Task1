package com.tarasenko.gof_patterns.behavioral;


import lombok.Getter;
import lombok.Setter;

interface Strategy {
    void doSearch(String filter);
}

class FirstSearchAlgo implements Strategy{
    @Override
    public void doSearch(String filter) {
        System.out.println("First search algorithm");
    }
}

class SecondSearchAlgo implements Strategy{
    @Override
    public void doSearch(String filter) {
        System.out.println("Second search algorithm");
    }
}

class DataSearch{
    @Getter
    @Setter
    private Strategy strategy;

    public DataSearch(Strategy strategy) {
        this.strategy = strategy;
    }

    public void searchAllData() {
        System.out.println("Searching..");
        strategy.doSearch("12345");
    }
}


public class StrategyPattern {
    public static void main(String[] args) {
        DataSearch dataSearch = new DataSearch(new FirstSearchAlgo());
        dataSearch.searchAllData();
    }
}
