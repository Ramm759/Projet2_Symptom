package com.hemebiotech.analytics.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SortSymptomFromHashMap implements ISymptomSort{
    private Map<String, Integer> hmap;

    /**
     * @param hmap : HashMap ( clé : String (nom) et valeur : Integer (nb occurences)
     *               retourne un HashMap ( clé : String (nom) et valeur : Integer (nb occurences)
     */

    // Constructeur
    public SortSymptomFromHashMap(Map<String, Integer> hmap) {
        this.hmap = hmap;
    }

    public List<String> SortSymptoms() {
        // Tri par ordre alphabétique
        List<String> symptoms = new ArrayList<>(hmap.keySet());
        Collections.sort(symptoms);
        return symptoms;
    }

}
