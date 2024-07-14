package org.restapi;
import org.restapi.examples.CountryAPI;
import org.restapi.examples.MedicalAPI;
import org.restapi.examples.MovieAPI;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        MedicalAPI medicalAPI = new MedicalAPI("/medical_records");
//        System.out.println(medicalAPI.getResponse());
//        int avg = medicalAPI.getAvgPulse(2, "Pulmonary embolism");
//        System.out.println(avg);

//        CountryAPI countryAPI = new CountryAPI("/countries");
//        System.out.println(countryAPI.getResponse());
//        String capital = countryAPI.getCapital("Afghanistan");
//        System.out.println(capital);

        MovieAPI movieAPI = new MovieAPI("/movies");
        System.out.println(movieAPI.getResponse());
        List<String> titles = movieAPI.getTitles();
        titles.forEach(System.out::println);
    }
}