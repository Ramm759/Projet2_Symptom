package com.hemebiotech.analytics.Count;

import java.util.List;
import java.util.Map;

public interface ISymptomCount {
    /**
     * If no data is available, return an empty Map
     * @param ArrayList<String> result (retourné par
     * @return a Map ( clé : String (nom) et valeur : Integer (nb occurences)
     */

    Map<String, Integer> countSymptoms(List<String> result);
}
