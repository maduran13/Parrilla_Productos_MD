package com.application.products.services;

import com.application.products.models.Product;
import com.application.products.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductsRepository productsRepository;

    public ProductService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Integer> getProductsList(){
        List<Integer> idProducts = productsRepository.getProductsIds();
        List<Integer> nuevo = new ArrayList<>();
        int i = 0;
        while (i < idProducts.size()) {
            Optional<Product> productWithSpecialSizes = productsRepository.getProductWithSpecialSizes(idProducts.get(i));
            Optional<Product> productWithBackSoonSpecial = productsRepository.getProductWithBackSoonSpecial(idProducts.get(i));
            Optional<Product> productWithoutSpecialSizes = productsRepository.getProductWithoutSpecialSizes(idProducts.get(i));
            Optional<Product> productWithBackSoonNoSpecial = productsRepository.getProductWithBackSoonNoSpecial(idProducts.get(i));
            boolean hasSpecialSizes = productWithSpecialSizes.isPresent();
            boolean hasBackSoonSpecial = productWithBackSoonSpecial.isPresent();
            boolean hasNoSpecial = productWithoutSpecialSizes.isPresent();
            boolean hasBackSoonNoSpecial = productWithBackSoonNoSpecial.isPresent();
            if ((hasSpecialSizes || hasBackSoonSpecial)&&(hasNoSpecial||hasBackSoonNoSpecial)) {
                nuevo.add(idProducts.get(i));
            } else if (hasBackSoonNoSpecial || hasNoSpecial) {
                nuevo.add(idProducts.get(i));
            }
            i++;
        }
        return nuevo;
    }
}
