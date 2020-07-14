package com.hemebiotech.analytics.Sort;

import java.util.List;
import java.util.Map;

public interface ISymptomSort {
    /**
     * If no data is available, return an empty List
     *
     * @return List trié
     */

    List<String> sortSymptoms(Map<String, Integer> hmap);
}
