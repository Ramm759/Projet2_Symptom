package com.hemebiotech.analytics;
import com.hemebiotech.analytics.Count.CountSymptomFromArrayList;
import com.hemebiotech.analytics.Count.ISymptomCount;
import com.hemebiotech.analytics.Read.ISymptomReader;
import com.hemebiotech.analytics.Read.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.Sort.ISymptomSort;
import com.hemebiotech.analytics.Sort.SortSymptomFromHashMap;
import com.hemebiotech.analytics.Write.ISymptomWrite;
import com.hemebiotech.analytics.Write.WriteToFile;

import java.io.FileWriter;
import java.util.*;

public class AnalyticsCounter {
    public static void main(String args[]) {

        // Lecture fichier .txt

        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        List<String> result = reader.GetSymptoms();

        // Comptage des symptomes
        ISymptomCount counter = new CountSymptomFromArrayList(result);
        Map<String, Integer> hmap = counter.CountSymptoms();

        // Tri par ordre alphabétique
        ISymptomSort sort = new SortSymptomFromHashMap(hmap);
        List<String> symptoms = sort.SortSymptoms();

        // Ecriture du fichier result.out
        ISymptomWrite writer = new WriteToFile(symptoms, hmap);
        writer.WriteSymptoms();
        

}
}
