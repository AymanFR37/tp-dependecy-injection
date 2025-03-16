package com.backend.metier;

import com.backend.dao.IDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("metier")
public class MetierImpl implements IMetier {
    // Couplage faible
    private IDao dao;

    public MetierImpl(@Qualifier("dao1") IDao dao) {
        this.dao = dao;
    }

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
