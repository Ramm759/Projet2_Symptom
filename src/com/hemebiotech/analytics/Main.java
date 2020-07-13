package com.hemebiotech.analytics;

import com.hemebiotech.analytics.Count.CountSymptomFromArrayList;
import com.hemebiotech.analytics.Count.ISymptomCount;
import com.hemebiotech.analytics.Read.ISymptomReader;
import com.hemebiotech.analytics.Read.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.Sort.ISymptomSort;
import com.hemebiotech.analytics.Sort.SortSymptomFromHashMap;
import com.hemebiotech.analytics.Write.ISymptomWrite;
import com.hemebiotech.analytics.Write.WriteToFile;

public class Main {
    public static void main(String[] args) throws Exception{
        // Instanciation des Interfaces
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomCount counter = new CountSymptomFromArrayList();
        ISymptomSort sorter = new SortSymptomFromHashMap();
        ISymptomWrite writer = new WriteToFile("result.out");

        // Instanciation et lancement execute()
        new AnalyticsCounter(reader, counter, sorter, writer).execute();
    }
}
