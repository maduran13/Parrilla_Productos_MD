package com.application.products.models;

public class Product {

    private Integer id;
    private Integer sequence;
    private Integer sizeId;
    private Integer quantity;

    public Product(Integer id, Integer sequence, Integer sizeId, Integer quantity) {
        this.id = id;
        this.sequence = sequence;
        this.sizeId = sizeId;
        this.quantity = quantity;
    }


    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}
