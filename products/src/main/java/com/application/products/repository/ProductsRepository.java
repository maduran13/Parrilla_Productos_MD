package com.application.products.repository;

import com.application.products.daos.ProductsDao;
import com.application.products.mappers.ProductRowMapper;
import com.application.products.models.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductsRepository implements ProductsDao {

    private final JdbcTemplate jdbcTemplate;

    public ProductsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Product> getProductWithSpecialSizes(int id) {
        var sql= "SELECT product.id product_id, product.sequence, size.id size_id, stock.quantity " +
                "FROM product JOIN size ON product.id = size.product_id join stock on size.id = stock.size_id " +
                "where size.special = 'T' and stock.quantity >0 and product.id = ?";
        return jdbcTemplate.query(sql, new ProductRowMapper(), id).stream().findFirst();
    }

    @Override
    public Optional<Product> getProductWithoutSpecialSizes(int id) {
        var sql= "SELECT product.id product_id, product.sequence, size.id size_id, stock.quantity " +
                "FROM product JOIN size ON product.id = size.product_id join stock on size.id = stock.size_id " +
                "where size.special = 'F' and stock.quantity >0 and product.id = ?";
        return jdbcTemplate.query(sql, new ProductRowMapper(), id).stream().findFirst();
    }

    @Override
    public Optional<Product> getProductWithBackSoonSpecial(int id) {
        var sql = "SELECT product.id product_id, product.sequence, size.id size_id, stock.quantity " +
                "FROM product JOIN size ON product.id = size.product_id join stock on size.id = stock.size_id " +
                "where size.special = 'T' and stock.quantity <= 0 and size.back_soon = 'T' and product.id = ?";
        return jdbcTemplate.query(sql, new ProductRowMapper(), id).stream().findFirst();
    }

    @Override
    public Optional<Product> getProductWithBackSoonNoSpecial(int id) {
        var sql = "SELECT product.id product_id, product.sequence, size.id size_id, stock.quantity " +
                "FROM product JOIN size ON product.id = size.product_id join stock on size.id = stock.size_id " +
                "where size.special = 'F' and stock.quantity <= 0 and size.back_soon = 'T' and product.id = ?";
        return jdbcTemplate.query(sql, new ProductRowMapper(), id).stream().findFirst();
    }

    @Override
    public List<Integer> getProductsIds() {
        var sql = "SELECT product.id FROM product";
        return jdbcTemplate.queryForList(sql, Integer.class);
    }
}
