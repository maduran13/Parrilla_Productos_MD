package com.application.products.services;

import com.application.products.daos.SizesDao;
import com.application.products.models.Size;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService {
    private final SizesDao sizesDao;

    public SizeService(SizesDao sizesDao) {
        this.sizesDao = sizesDao;
    }

    public Boolean isThereSpecialSizes(){
        return sizesDao.isAnyEspecial().size()>0;
    }
}
