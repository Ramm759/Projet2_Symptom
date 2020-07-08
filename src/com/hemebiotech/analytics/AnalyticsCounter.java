package com.hemebiotech.analytics;
import com.hemebiotech.analytics.Count.CountSymptomFromArrayList;
import com.hemebiotech.analytics.Read.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.Sort.SortSymptomFromHashMap;
import com.hemebiotech.analytics.Write.WriteToFile;

import java.io.FileWriter;
import java.util.*;

public class AnalyticsCounter {
    public static void main(String args[]) throws Exception {

        // Lecture fichier .txt
        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
        List<String> result = reader.GetSymptoms();

        // Comptage des symptomes
        CountSymptomFromArrayList counter = new CountSymptomFromArrayList(result);
        Map<String, Integer> hmap = counter.CountSymptoms();

        // Tri par ordre alphabétique
        SortSymptomFromHashMap sort = new SortSymptomFromHashMap(hmap);
        List<String> symptoms = sort.SortSymptoms();

        // Ecriture du fichier result.out
        WriteToFile writer = new WriteToFile( symptoms, hmap);
        writer.WriteSymptoms();
        

}
}
