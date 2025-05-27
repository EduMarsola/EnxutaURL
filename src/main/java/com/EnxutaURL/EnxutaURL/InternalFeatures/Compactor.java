package com.EnxutaURL.EnxutaURL.InternalFeatures;

import java.time.LocalTime;
import java.util.Random;
import java.util.random.RandomGenerator;

public abstract class Compactor {
    static String[] base = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "A", "B", "C", "D", "E"};

    public static String compact(String originalURL){
        StringBuilder compactResponse = new StringBuilder("www.EnxutaURL/");
        for(int i = 0; i<Size(); i++){
            compactResponse.append(base[RandomGenerator.getDefault().nextInt(0, base.length)]);
        }
        return compactResponse.toString();
    }

    private static int Size(){
        return RandomGenerator.getDefault().nextInt(5, 10);
    }
}
