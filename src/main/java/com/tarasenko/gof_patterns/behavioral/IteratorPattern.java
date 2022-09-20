package com.tarasenko.gof_patterns.behavioral;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


record Good(String name, int price) {
}


class GoodsCatalog implements Iterator<Good> {
    private final List<Good> goods = new ArrayList<>();
    private int iteratorPosition = 0;


    public void add(Good good) {
        goods.add(good);
    }

    @Override
    public boolean hasNext() {
        return iteratorPosition < goods.size();
    }

    @Override
    public Good next() {
        if (hasNext()) {
            return goods.get(iteratorPosition++);
        }

        return null;
    }
}



public class IteratorPattern {

    public static void main(String[] args) {
        GoodsCatalog fruitCatalog = new GoodsCatalog();
        fruitCatalog.add(new Good("Apple", 50));
        fruitCatalog.add(new Good("Banana", 20));
        fruitCatalog.add(new Good("Peach", 40));
        fruitCatalog.add(new Good("Mango", 60));
        fruitCatalog.add(new Good("Kiwi", 70));

        while (fruitCatalog.hasNext()) {
            System.out.println(fruitCatalog.next());
        }
    }

}