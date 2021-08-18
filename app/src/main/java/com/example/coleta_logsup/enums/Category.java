package com.example.coleta_logsup.enums;

public enum Category {
    CARE(1), COMFORT(2),TOY(3), HEALTH(4), SERVICE(5);

    public int value;

    Category(int value){
        this.value = value;
    }

    public static String stringfy(int index){
        switch(index){
            case 1:
                return "Cuidado";

            case 2:
                return "Conforto";

            case 3:
                return "Brinquedos";

            case 4:
                return "Saúde";

            case 5:
                return "Serviço";
        }
        return  null;
    }
}
