package com.backend.dao;

import org.springframework.stereotype.Repository;

@Repository("dao2")
public class DaoImplV2 implements IDao {
    @Override
    public double getData() {
        System.out.println("Dao implementation V2");
        return 20.0;
    }
}
