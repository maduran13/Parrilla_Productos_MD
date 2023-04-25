package com.application.products;

import com.application.products.mappers.IProductRowMapper;
import com.application.products.mappers.ProductRowMapper;
import com.application.products.models.Product;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductRowMapperTest {
    @Test
    public void testMapRow() throws SQLException {
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockResultSet.getInt("product_id")).thenReturn(1);
        when(mockResultSet.getInt("sequence")).thenReturn(2);
        when(mockResultSet.getInt("size_id")).thenReturn(3);
        when(mockResultSet.getInt("quantity")).thenReturn(4);

        IProductRowMapper productRowMapper = new ProductRowMapper();
        Product product = productRowMapper.mapRow(mockResultSet, 1);

        assertEquals(1, product.getId());
        assertEquals(2, product.getSequence());
        assertEquals(3, product.getSizeId());
        assertEquals(4, product.getQuantity());
    }
}

