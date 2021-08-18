package com.example.coleta_logsup.enums;

public enum Roles {
    MANAGER(0), SUPPLIER(1), DIRECTOR(2), PRESIDENT(3);

    public int value;

    Roles(int value){
        this.value = value;
    }

    public static String stringfy(int index){
        switch(index){
            case 1:
                return "Analista";

            case 2:
                return "Gerente";

            case 3:
                return "Diretor";

            case 4:
                return "Presidente";
        }
        return  null;
    }
}
