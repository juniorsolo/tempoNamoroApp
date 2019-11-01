package com.junior.tempodenamoro.util;

import java.util.ArrayList;
import java.util.Random;

public class GeneratePhrase {


    public static String Generate(){
        ArrayList<String> phrases = GeneratePhrase.createPhrases();
        int r = new Random().nextInt(phrases.size());
        return phrases.get(r);
    }

    private static ArrayList<String> createPhrases(){
        ArrayList<String> phrases = new ArrayList<>();

        phrases.add("Seu estocolmo não tem cura, mas é isso que amo em vc...");
        phrases.add("Esse amor deixa meu coração pocando...");
        phrases.add("Ja te disse que te amo hoje? Te amo :)");
        phrases.add("Um choop de vinho e você, combinação perfeita :)");
        phrases.add("Você torna meu dia melhor.");
        phrases.add("Eu continuo sonhando que você está comigo.");
        phrases.add("Você sempre me surpreende.");
        phrases.add("Preciso do seu beijo...");
        phrases.add("Tudo que mais quero é ficar agarradinho com você.");
        phrases.add("Lembra da abelha em São Roque? rsrs");
        phrases.add("Assitir série é bom, com você fica melhor ainda.");
        phrases.add("Mais um dia que tenho você ao meu lado.");
        phrases.add("O amor é cultivado dia a dia.");
        phrases.add("Você começou a me amar, no dia que comeu do meu risoto kkkk");
        phrases.add("Você vai pocar de tanto amor.");
        phrases.add("Saudade da estrada indo pra monte verde...");
        phrases.add("Vai me dar beijinho hoje?");
        phrases.add("Você e eu , um vinho e alguns petiscos... perfeito");
        phrases.add("Acho que pegar a estrada seria uma boa, não acha?");
        phrases.add("Quero um beijo seu.");

        return phrases;
    }

}
