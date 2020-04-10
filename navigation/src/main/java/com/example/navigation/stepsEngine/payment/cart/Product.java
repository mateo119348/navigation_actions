package com.example.navigation.stepsEngine.payment.cart;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Product {

    private Long id;
    private String itemId;
    private String title;
    private Double price;
    private String reservationCurrency;
    private Double fullPrice;
    private String description;
    private String thumbnail;
    private String secureThumbnail;
    private String pictureUrl;
    private String pictureSecureUrl;
    private String pictureSize;
    private String initials;
    private String color = "#FFA1DFF3";
    private String sellerId;
    private String siteId;
    private String currencyId;
    private Date dateCreated;
    private Date lastUpdate;
    private Integer quantity;
    private Long categoryId;
    private ProductCategory category;
    private List<ProductVariant> variants = new ArrayList<ProductVariant>();
    private boolean selected;
    private ProductVariant variantSelected;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getReservationCurrency() {
        return reservationCurrency;
    }

    public void setReservationCurrency(String reservationCurrency) {
        this.reservationCurrency = reservationCurrency;
    }

    public Double getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(Double fullPrice) {
        this.fullPrice = fullPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSecureThumbnail() {
        return secureThumbnail;
    }

    public void setSecureThumbnail(String secureThumbnail) {
        this.secureThumbnail = secureThumbnail;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPictureSecureUrl() {
        return pictureSecureUrl;
    }

    public void setPictureSecureUrl(String pictureSecureUrl) {
        this.pictureSecureUrl = pictureSecureUrl;
    }

    public String getPictureSize() {
        return pictureSize;
    }

    public void setPictureSize(String pictureSize) {
        this.pictureSize = pictureSize;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
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

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public List<ProductVariant> getVariants() {
        return variants;
    }

    public void setVariants(List<ProductVariant> variants) {
        this.variants = variants;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public ProductVariant getVariantSelected() {
        return variantSelected;
    }

    public void setVariantSelected(ProductVariant variantSelected) {
        this.variantSelected = variantSelected;
    }

}