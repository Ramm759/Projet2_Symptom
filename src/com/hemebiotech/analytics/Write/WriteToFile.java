package com.hemebiotech.analytics.Write;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WriteToFile implements ISymptomWrite{
    private List<String> symptoms;
    private Map<String, Integer> hmap;

    // Constructeur
    public WriteToFile(List<String> symptoms, Map<String, Integer> hmap) {
        this.symptoms = symptoms;
        this.hmap = hmap;
    }

    @Override
    public void WriteSymptoms() {
        try {
            // Création du fichier de sortie "result.out"
            FileWriter writer = new FileWriter("result.out");

            for (String symptom : symptoms) {
                // Ecriture dans result.out ( format : nom symptome : nombre occurence
                writer.write(symptom + " : " + hmap.get(symptom) + "\n");
            }
            // fermeture fichier result.out
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
