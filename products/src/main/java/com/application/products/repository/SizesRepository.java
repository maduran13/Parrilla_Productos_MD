package com.application.products.repository;

import com.application.products.daos.SizesDao;
import com.application.products.mappers.SizeRowMapper;
import com.application.products.models.ISize;
import com.application.products.models.Size;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SizesRepository implements SizesDao {

    private final JdbcTemplate jdbcTemplate;

    public SizesRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Size> isAnyEspecial() {
        var sql= "SELECT * FROM size where special = 'T'";
        return jdbcTemplate.query(sql, new SizeRowMapper());
    }

    @Override
    public Boolean isStockAvailable() {
        var sql= "SELECT * FROM size where special = 'T'";
        return jdbcTemplate.query(sql, new SizeRowMapper());
    }

    @Override
    public Boolean atLeastOneSpecialAvailable() {
        return null;
    }

    @Override
    public Boolean isBackSoon() {
        return null;
    }
}
