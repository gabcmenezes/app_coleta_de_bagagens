package com.example.coleta_logsup.daos.seeds;

import com.example.coleta_logsup.daos.BaggageDAO;
import com.example.coleta_logsup.models.Baggage;

import java.util.ArrayList;
import java.util.List;


public class BaggagesSeeds {

    public static List<Baggage> getCollection() {
        List<Baggage> baggages = new ArrayList<>();
        //baggages.add(new Baggage("Gabriel",baggages 1 ));
        //baggages.add(new Baggage("Jonathan Fonseca",90));
        //baggages.add(new Baggage("Rafael Faria", 60));

        return baggages;
    }

    public static void install(BaggageDAO userDAO){
        for (Baggage user : getCollection()){
            userDAO.insert(user);
        }
    }
}
