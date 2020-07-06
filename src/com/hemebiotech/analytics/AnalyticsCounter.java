package com.hemebiotech.analytics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class AnalyticsCounter {
    public static void main(String args[]) throws Exception {

        // Ouverture du fichier symptom.txt
        BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));

        // Création du fichier de sortie "result.out"
        FileWriter writer = new FileWriter("result.out");

        // Création d'un HashMap avec le fichier symptoms.txt ( clé : String (nom) et valeur : Integer (nb occurences)
        Map<String, Integer> hmap = new HashMap<String, Integer>();

        // Lecture premiere ligne
        String line = reader.readLine();

        // parcourir le fichier et stocker les symptomes (lignes) dans hmap

        while (line != null) {
            // Si le symptome n'est pas déjà référencé dans hmap on le crée
            if (!hmap.containsKey(line)) { // si pas de clé correspondante
                hmap.put(line, 1);          // nombre occurence = 1
            } else {
                // le symptome existe déjà, on incremente le nombre d'occurence
                int nbOccurence = hmap.get(line);
                hmap.put(line, nbOccurence + 1);
            }
            // Ligne suivante
            line = reader.readLine();

        }

        // Tri par ordre alphabétique
        List<String> symptoms= new ArrayList<>(hmap.keySet());
        Collections.sort(symptoms);

        for (String symptom:symptoms) {

            // Ecriture dans result.out ( format : nom symptome : nombre occurence
            writer.write(symptom + " : " + hmap.get(symptom) + "\n");
    }
        // fermeture fichier result.out
        writer.close();
}}
