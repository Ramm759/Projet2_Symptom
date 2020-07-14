package com.hemebiotech.analytics.Write;

import java.util.List;
import java.util.Map;

public interface ISymptomWrite {
    void writeSymptoms(List<String> symptoms, Map<String, Integer> hmap);
}
