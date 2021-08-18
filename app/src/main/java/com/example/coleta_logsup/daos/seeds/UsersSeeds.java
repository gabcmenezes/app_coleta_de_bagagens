package com.example.coleta_logsup.daos.seeds;

import com.example.coleta_logsup.daos.UserDAO;
import com.example.coleta_logsup.enums.Roles;
import com.example.coleta_logsup.models.User;

import java.util.ArrayList;
import java.util.List;


public class UsersSeeds{

    public static List<User> getCollection() {
        List<User> users = new ArrayList<>();
        users.add(new User("Gabriel", "Camargo", 11122233344L, "password_2", 1144556677, Roles.MANAGER.value, false));
        users.add(new User("Rafael", " Faria", 22233344455L, "password_3", 1155667788, Roles.SUPPLIER.value, true));
        users.add(new User("Jonathan", "Fonseca", 33344455566L, "password_4", 1166778899, Roles.PRESIDENT.value, false));
        return users;
    }

    public static void install(UserDAO userDAO){
        for (User user : getCollection()){
            userDAO.insert(user);
        }
    }
}
