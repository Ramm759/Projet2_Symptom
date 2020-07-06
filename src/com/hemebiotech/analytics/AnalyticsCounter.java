package com.hemebiotech.analytics;
import com.hemebiotech.analytics.Read.ReadSymptomDataFromFile;
import java.io.FileWriter;
import java.util.*;

public class AnalyticsCounter {
    public static void main(String args[]) throws Exception {

        // Création du fichier de sortie "result.out"
        FileWriter writer = new FileWriter("result.out");

        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
        List<String> result = reader.GetSymptoms();

        // Création d'un HashMap avec le fichier symptoms.txt ( clé : String (nom) et valeur : Integer (nb occurences)
        Map<String, Integer> hmap = new HashMap<String, Integer>();

        // Remplir le HashMap avec "result"

        for (int i = 0; i < result.size(); i++) {

            String line = result.get(i);

            if (!hmap.containsKey(result.get(i))) { // si pas de clé correspondante
                hmap.put(line, 1);          // nombre occurence = 1
                //System.out.println(line);
            } else {
                // le symptome existe déjà, on incremente le nombre d'occurence
                int nbOccurence = hmap.get(line);
                hmap.put(line, nbOccurence + 1);
            }
        }

        // Tri par ordre alphabétique
        List<String> symptoms = new ArrayList<>(hmap.keySet());
        Collections.sort(symptoms);

        for (String symptom : symptoms) {

            // Ecriture dans result.out ( format : nom symptome : nombre occurence
            writer.write(symptom + " : " + hmap.get(symptom) + "\n");

        }
        // fermeture fichier result.out
        writer.close();
    }
}
