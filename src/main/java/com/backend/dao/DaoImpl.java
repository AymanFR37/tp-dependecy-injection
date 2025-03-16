package com.backend.dao;

public class DaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("Dao implementation V1");
        return 10.0;
    }
}
