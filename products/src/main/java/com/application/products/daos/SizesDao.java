package com.application.products.daos;

import com.application.products.models.ISize;
import com.application.products.models.Size;

import java.util.List;
import java.util.Optional;

public interface SizesDao {
    List<Size> isAnyEspecial();
    Boolean isStockAvailable();
    Boolean atLeastOneSpecialAvailable();
    Boolean isBackSoon();
}
