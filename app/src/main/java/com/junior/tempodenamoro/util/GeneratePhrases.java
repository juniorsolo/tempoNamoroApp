package com.junior.tempodenamoro.util;

import java.util.ArrayList;
import java.util.Random;

public class GeneratePhrases {


    public static String Generate(){
        ArrayList<String> phrases = GeneratePhrases.createPhrase();
        int r = new Random().nextInt(phrases.size());
        return phrases.get(r);
    }

    private static ArrayList<String> createPhrase(){
        ArrayList<String> phrases = new ArrayList<>();

        phrases.add("Seu estocolmo não tem cura, mas é isso q amo em vc...");
        phrases.add("Esse amor deixa meu coração pocando...");
        phrases.add("Ja te disse que te amo hoje?");
        phrases.add("Um choop de vinho e vc, combinação perfeita :-)");
        return phrases;
    }

}
