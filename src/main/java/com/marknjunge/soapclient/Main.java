package com.marknjunge.soapclient;

import com.marknjunge.soapclient.client.UniversityClient;
import com.marknjunge.soapclient.configuration.UniversityConfiguration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import universities.wsdl.GetAllUniversitiesResponse;
import universities.wsdl.GetUniversityResponse;
import universities.wsdl.University;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UniversityConfiguration universityConfiguration = new UniversityConfiguration();
        Jaxb2Marshaller marshaller = universityConfiguration.marshaller();
        UniversityClient universityClient = universityConfiguration.universityClient(marshaller);

        System.out.println("==============================");
        System.out.println("==== Get all universities ====");
        System.out.println("==============================");
        GetAllUniversitiesResponse allUniversities = universityClient.getAllUniversities();
        printUniversities(allUniversities.getUniversities());

        System.out.println();
        System.out.println("==========================================");
        System.out.println("==== Get all universities at location ====");
        System.out.println("==========================================");
        GetAllUniversitiesResponse allUniversitiesAtLocation = universityClient.getAllUniversitiesAtLocation("Ruiru");
        printUniversities(allUniversitiesAtLocation.getUniversities());

        System.out.println();
        System.out.println("================================");
        System.out.println("==== Get university by name ====");
        System.out.println("================================");
        GetUniversityResponse universityByName = universityClient.getUniversityByName("Strathmore");
        printUniversity(universityByName.getUniversity());
    }

    private static void printUniversity(University university) {
        System.out.println(String.format("name: %s, location: %s, yearFounded: %d", university.getName(), university.getLocation(), university.getYearFounded()));
    }

    private static void printUniversities(List<University> universities) {
        for (University university : universities) {
            printUniversity(university);
        }
    }
}
