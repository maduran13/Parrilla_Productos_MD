package com.application.products.repository;

import com.application.products.daos.ProductsDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductsRepository implements ProductsDao {

    @Override
    public List<Integer> getProductsAvailable() {
        return null;
    }
}
