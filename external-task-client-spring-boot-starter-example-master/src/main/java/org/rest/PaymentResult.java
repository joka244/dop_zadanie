package org.rest;

public class PaymentResult {
    String productInfo;
    int quantity;
    double price;
    String resultMessage;

    public PaymentResult() {
        this.productInfo = "error";
        this.quantity = 0;
        this.price = 0;
        this.resultMessage = "Error";
    }

    public PaymentResult(String productInfo, int quantity, double price, String resultMessage) {
        this.productInfo = productInfo;
        this.quantity = quantity;
        this.price = price;
        this.resultMessage = resultMessage;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
