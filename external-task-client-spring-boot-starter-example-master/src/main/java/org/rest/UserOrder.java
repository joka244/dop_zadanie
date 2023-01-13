package org.rest;

public class UserOrder {
    private String productId;
    private int quantity;

    public UserOrder() {}

    public UserOrder(UserReserve reserve) {
        this.productId = reserve.getClothes().getId();
        this.quantity = reserve.getQuantity();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
