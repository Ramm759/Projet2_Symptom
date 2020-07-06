package com.hemebiotech.analytics.Count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSymptomFromArrayList implements ISymptomCount{
    private List<String> result;

    /**
     * @param result : liste de symptomes, 1 symptome par ligne
     *               retourne un HashMap ( clé : String (nom) et valeur : Integer (nb occurences)
     */

    // Constructeur
    public CountSymptomFromArrayList(List<String> result) {
        this.result = result;
    }

    public Map<String, Integer> CountSymptoms() {

        // Création d'un HashMap ( clé : String (nom) et valeur : Integer (nb occurences)
        Map<String, Integer> hmap = new HashMap<String, Integer>();

        // Remplir le HashMap avec "result"

        for (int i = 0; i < result.size(); i++) {

            String line = result.get(i);

            if (!hmap.containsKey(result.get(i))) { // si pas de clé correspondante
                hmap.put(line, 1);          // nombre occurence = 1
                //System.out.println(line);
            } else {
                // le symptome existe déjà, on incremente le nombre d'occurence
                int nbOccurence = hmap.get(line);
                hmap.put(line, nbOccurence + 1);
            }
        }
        return hmap;
    }
}
