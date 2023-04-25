package com.application.products.mappers;

import com.application.products.models.ISize;
import com.application.products.models.Size;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SizeRowMapper implements ISizeRowMapper{

    @Override
    public Size mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Size(
                resultSet.getInt("id"),
                resultSet.getInt("product_id"),
                resultSet.getBoolean("back_soon"),
                resultSet.getBoolean("special")
        );
    }
}
