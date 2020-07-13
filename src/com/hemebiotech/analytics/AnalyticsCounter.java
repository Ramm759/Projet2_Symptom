package com.hemebiotech.analytics;

import com.hemebiotech.analytics.Count.ISymptomCount;
import com.hemebiotech.analytics.Read.ISymptomReader;
import com.hemebiotech.analytics.Sort.ISymptomSort;
import com.hemebiotech.analytics.Write.ISymptomWrite;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

    // On rend obligatoire la création des 4 interfaces avant d'utiliser l'objet
    private final ISymptomReader reader;
    private final ISymptomCount counter;
    private final ISymptomSort sorter;
    private final ISymptomWrite writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomCount counter, ISymptomSort sorter, ISymptomWrite writer) {
        this.reader = reader;
        this.counter = counter;
        this.sorter = sorter;
        this.writer = writer;
    }

    public void execute() throws Exception {
        // Lecture fichier .txt
        List<String> result = reader.GetSymptoms();

        // Comptage des symptomes
        Map<String, Integer> hmap = counter.CountSymptoms(result);

        // Tri par ordre alphabétique
        List<String> symptoms = sorter.SortSymptoms(hmap);

        // Ecriture du fichier result.out
        writer.WriteSymptoms(symptoms, hmap);

    }
}
