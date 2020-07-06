package com.hemebiotech.analytics.Count;

import java.util.List;
import java.util.Map;

public interface ISymptomCount {
    /**
     * If no data is available, return an empty Map
     *
     * @return a Map ( clé : String (nom) et valeur : Integer (nb occurences)
     */

    Map<String, Integer> CountSymptoms();
}
