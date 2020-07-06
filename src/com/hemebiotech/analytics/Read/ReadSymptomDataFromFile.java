package com.hemebiotech.analytics.Read;

import com.hemebiotech.analytics.Read.ISymptomReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 * Retourne un List contenant la liste des symptomes du fichier txt
	 */

	// Constructeur
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				// Ouverture du fichier symptom.txt
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				// Lecture premiere ligne
				String line = reader.readLine();
				
				while (line != null) {
					// On ajoute la ligne en cours à la liste
					result.add(line);
					// Ligne suivante
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}