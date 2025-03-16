package com.backend.dao;

public class DaoImplV2 implements IDao {
    @Override
    public double getData() {
        System.out.println("Dao implementation V2");
        return 20.0;
    }
}
