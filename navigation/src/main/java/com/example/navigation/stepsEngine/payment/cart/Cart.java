package com.example.navigation.stepsEngine.payment.cart;

import java.util.Date;
import java.util.List;

public class Cart {

    private Long id;
    private Double rawAmount = 0d;
    private Double rawFullPriceAmount = 0d;
    private String sellerId;
    private String currencyId;
    private Date dateCreated;
    private Date lastUpdated;
    private String paymentId;
    private String paymentStatus;
    private List<Product> products;
    private Discount discount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRawAmount() {
        return rawAmount;
    }

    public void setRawAmount(Double rawAmount) {
        this.rawAmount = rawAmount;
    }

    public Double getRawFullPriceAmount() {
        return rawFullPriceAmount;
    }

    public void setRawFullPriceAmount(Double rawFullPriceAmount) {
        this.rawFullPriceAmount = rawFullPriceAmount;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

}
