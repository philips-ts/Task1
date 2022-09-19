package com.tarasenko.gof_patterns.creational;

public class LazySingleton {
    private static volatile LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance(){
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }

        return instance;
    }


    public static void main(String[] args) {
        LazySingleton instance1 = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();

        System.out.println(instance1 == instance2);
    }
}
