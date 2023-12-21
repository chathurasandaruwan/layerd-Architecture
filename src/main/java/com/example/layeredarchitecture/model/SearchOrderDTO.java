package com.example.layeredarchitecture.model;

import java.time.LocalDate;

public class SearchOrderDTO {
    private String orderId;
    private LocalDate date;
    private String customerId;
    private String itemCode;
    private int qtyOnHand;

    public SearchOrderDTO() {
    }

    public SearchOrderDTO(String orderId, LocalDate date, String customerId, String itemCode, int qtyOnHand) {
        this.orderId = orderId;
        this.date = date;
        this.customerId = customerId;
        this.itemCode = itemCode;
        this.qtyOnHand = qtyOnHand;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    @Override
    public String toString() {
        return "SearchOrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", date=" + date +
                ", customerId='" + customerId + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", qtyOnHand=" + qtyOnHand +
                '}';
    }
}
