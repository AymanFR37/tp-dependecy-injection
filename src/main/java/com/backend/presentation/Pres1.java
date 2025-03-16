package com.backend.presentation;

import com.backend.dao.DaoImpl;
import com.backend.metier.MetierImpl;

public class Pres1 {
    public static void main(String[] args) {
        DaoImpl dao = new DaoImpl();
        //DaoImplV2 dao2 = new DaoImplV2();
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao);

        System.out.println("Résultat : " + metier.calcul());
    }
}
