package com.hemebiotech.analytics;
import com.hemebiotech.analytics.Count.CountSymptomFromArrayList;
import com.hemebiotech.analytics.Read.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.Sort.SortSymptomFromHashMap;

import java.io.FileWriter;
import java.util.*;

public class AnalyticsCounter {
    public static void main(String args[]) throws Exception {

        // Création du fichier de sortie "result.out"
        FileWriter writer = new FileWriter("result.out");

        // Lecture fichier .txt
        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
        List<String> result = reader.GetSymptoms();

        // Comptage des symptomes
        CountSymptomFromArrayList counter = new CountSymptomFromArrayList(result);
        Map<String, Integer> hmap = counter.CountSymptoms();

        // Tri par ordre alphabétique
        SortSymptomFromHashMap sort = new SortSymptomFromHashMap(hmap);
        List<String> symptoms = sort.SortSymptoms();
        
        for (String symptom : symptoms) {

            // Ecriture dans result.out ( format : nom symptome : nombre occurence
            writer.write(symptom + " : " + hmap.get(symptom) + "\n");

        }
        // fermeture fichier result.out
        writer.close();
    }
}
