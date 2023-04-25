package com.application.products.daos;

public interface SizesDao {
    Boolean isAnyEspecial();
    Boolean isStockAvailable();
    Boolean atLeastOneSpecialAvailable();
    Boolean isBackSoon();
}
