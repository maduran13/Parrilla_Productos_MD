package com.application.products.mappers;

import com.application.products.models.ISize;
import com.application.products.models.Size;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ISizeRowMapper extends RowMapper<Size> {
    @Override
    Size mapRow(ResultSet resultSet, int i) throws SQLException;
}
