package com.hemebiotech.analytics.Write;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WriteToFile implements ISymptomWrite {

    /**
     * @param List<String> symptoms
     */

    private String filePath;

    // Constructeur
    public WriteToFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeSymptoms(List<String> symptoms, Map<String, Integer> hmap) {
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
