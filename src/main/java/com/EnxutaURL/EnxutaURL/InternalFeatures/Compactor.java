package com.EnxutaURL.EnxutaURL.InternalFeatures;

public abstract class Compactor {
    public static String compact(String originalURL){
        String[] base = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c"};
        StringBuilder compactResponse = new StringBuilder();
        for(int i = 0; i<5; i++){
            compactResponse.append(base[i]);
        }
        return compactResponse.toString();
    }
}
