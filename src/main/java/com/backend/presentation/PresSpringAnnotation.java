package com.backend.presentation;

import com.backend.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.backend");
        IMetier metier = ctx.getBean(IMetier.class);

        System.out.println("Résultat : " + metier.calcul());
    }
}
