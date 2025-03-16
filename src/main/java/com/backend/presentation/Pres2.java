package com.backend.presentation;

import com.backend.dao.IDao;
import com.backend.metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Exemple d'injection dynamique de dépendances avec réflexion.
 */
public class Pres2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("config.txt"));

        String daoClassName = scanner.nextLine();
        Class<?> cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.newInstance();

        String metierClassName = scanner.nextLine();
        Class<?> cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);
//        IMetier metier = (IMetier) cMetier.getConstructor().newInstance();
//        Method setDao = cMetier.getDeclaredMethod("setDao",IDao.class);
//        setDao.invoke(metier,dao);

        System.out.println("Résultat : " + metier.calcul());
    }
}
