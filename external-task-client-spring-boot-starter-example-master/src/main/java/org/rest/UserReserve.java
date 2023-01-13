package org.rest;

public class UserReserve {
    private Clothes clothes;
    private int quantity;

    public UserReserve() {
        this.clothes = new Clothes();
        this.quantity = 0;
    }

    public UserReserve(Clothes clothes, int quantity) {
        this.clothes = clothes;
        this.quantity = quantity;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
