package org.rest;

public class StoreAssortment {
    private Clothes[] clothess;
    private int[] quantity;

    public StoreAssortment(Clothes[] clothess, int[] quantity) {
        this.clothess = clothess;
        this.quantity = quantity;
    }

    public StoreAssortment() {
    }

    public void setQuantityFromIndex(int index, int value) {
        try {
            quantity[index] = value;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Clothes[] getClothess() {
        return clothess;
    }

    public void setClothess(Clothes[] clothess) {
        this.clothess = clothess;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public void setQuantity(int[] quantity) {
        this.quantity = quantity;
    }
}
