package com.example.coleta_logsup.daos.seeds;

import com.example.coleta_logsup.daos.AirportDAO;
import com.example.coleta_logsup.models.Airport;

import java.util.ArrayList;
import java.util.List;


public class AirportsSeeds {

     public static List<Airport> getCollection() {
        List<Airport> airport = new ArrayList<>();
        airport.add(new Airport("PA01", "SP"));
        airport.add(new Airport("PA02 ", "SP"));
        airport.add(new Airport("PA03", "RJ"));
        airport.add(new Airport("PA04", "RJ"));
        return airport;
    }

    public static void install(AirportDAO airportDAO){
        for (Airport airport : getCollection()){
            airportDAO.insert(airport);
        }
    }
}
