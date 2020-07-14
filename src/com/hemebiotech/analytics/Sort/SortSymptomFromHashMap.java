package com.hemebiotech.analytics.Sort;

import java.util.*;

public class SortSymptomFromHashMap implements ISymptomSort{

    /**
     * @param hmap : HashMap ( clé : String (nom) et valeur : Integer (nb occurences)
     *               retourne List<String> symptoms
     */

    public List<String> sortSymptoms(Map<String, Integer> hmap) {
        // Tri par ordre alphabétique
        List<String> symptoms = new ArrayList<>(hmap.keySet());
        Collections.sort(symptoms);
        return symptoms;
    }
}
