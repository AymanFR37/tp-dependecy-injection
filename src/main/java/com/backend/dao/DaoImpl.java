package com.backend.dao;

import org.springframework.stereotype.Repository;

@Repository("dao1") // Alias for @Component
public class DaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("Dao implementation V1");
        return 10.0;
    }
}
