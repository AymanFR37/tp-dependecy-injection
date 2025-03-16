package com.backend.metier;

import com.backend.dao.IDao;

public class MetierImpl implements IMetier {
    // Couplage faible
    private IDao dao;

    /**
     * Pour injecter dans l'attribut dao
     * un objet d'une classe qui implémente l'interface IDO
     * après instantiation
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double data = dao.getData();
        return data * 2;
    }
}
