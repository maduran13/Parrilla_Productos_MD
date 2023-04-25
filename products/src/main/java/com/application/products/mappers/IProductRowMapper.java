package com.application.products.mappers;

import com.application.products.models.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IProductRowMapper extends RowMapper<Product> {
    @Override
    Product mapRow(ResultSet resultSet, int i) throws SQLException;
}
