package com.application.products.mappers;

import com.application.products.models.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements IProductRowMapper{

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Product(
                resultSet.getInt("product_id"),
                resultSet.getInt("sequence"),
                resultSet.getInt("size_id"),
                resultSet.getInt("quantity")
        );
    }
}
