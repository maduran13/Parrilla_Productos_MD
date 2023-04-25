package com.application.products.models;

public class Size implements ISize{
    private Integer id;
    private Integer productId;
    private Boolean backSoon;
    private Boolean special;

    public Size(Integer id, Integer productId, Boolean backSoon, Boolean special) {
        this.id = id;
        this.productId = productId;
        this.backSoon = backSoon;
        this.special = special;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Boolean getBackSoon() {
        return backSoon;
    }

    public void setBackSoon(Boolean backSoon) {
        this.backSoon = backSoon;
    }

    public Boolean getSpecial() {
        return special;
    }

    public void setSpecial(Boolean special) {
        this.special = special;
    }


}
