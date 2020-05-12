package com.example.navigation.stepsEngine.payment;

import com.example.navigation.stepsEngine.enums.AccountType;
import com.example.navigation.stepsEngine.enums.Acquirer;
import com.example.navigation.stepsEngine.enums.FinancingFee;
import com.example.navigation.stepsEngine.enums.SiteId;
import com.example.navigation.stepsEngine.payment.card.Card;
import com.example.navigation.stepsEngine.payment.cart.Cart;
import com.example.navigation.stepsEngine.payment.device.Pos;

import java.math.BigDecimal;

public class FlowState {

    private Cart cart;
    private Pos pos;
    private Card card;
    private BigDecimal amount;
    private String description;
    private Identification buyerIdentification;
    private PaymentMethodWrapper paymentMethodWrapper;
    private Integer installments;
    private FinancingFee financingFee;
    private String pointTransactionId;
    private Location location;
    private StorePos storePos;
    private AccountType accountType;
    private String taxId;
    private Acquirer acquirer;
    private String paymentStatus;
    private Integration integration;
    private SiteId siteId;
    private Reservation reservation;
    private Signature signature;

    public FlowState() {
        this.card = new Card();
        this.paymentMethodWrapper = new PaymentMethodWrapper();
        this.pos = new Pos();
        this.buyerIdentification = new Identification();
        this.integration = new Integration();
        this.storePos = new StorePos();
        this.location = new Location();
        this.cart = new Cart();
        this.reservation = new Reservation();
    }


    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Pos getPos() {
        return pos;
    }

    public void setPos(Pos pos) {
        this.pos = pos;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Identification getBuyerIdentification() {
        return buyerIdentification;
    }

    public void setBuyerIdentification(Identification buyerIdentification) {
        this.buyerIdentification = buyerIdentification;
    }

    public PaymentMethodWrapper getPaymentMethodWrapper() {
        return paymentMethodWrapper;
    }

    public void setPaymentMethodWrapper(PaymentMethodWrapper paymentMethodWrapper) {
        this.paymentMethodWrapper = paymentMethodWrapper;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public FinancingFee getFinancingFee() {
        return financingFee;
    }

    public void setFinancingFee(FinancingFee financingFee) {
        this.financingFee = financingFee;
    }

    public String getPointTransactionId() {
        return pointTransactionId;
    }

    public void setPointTransactionId(String pointTransactionId) {
        this.pointTransactionId = pointTransactionId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public StorePos getStorePos() {
        return storePos;
    }

    public void setStorePos(StorePos storePos) {
        this.storePos = storePos;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public Acquirer getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(Acquirer acquirer) {
        this.acquirer = acquirer;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integration getIntegration() {
        return integration;
    }

    public void setIntegration(Integration integration) {
        this.integration = integration;
    }

    public SiteId getSiteId() {
        return siteId;
    }

    public void setSiteId(SiteId siteId) {
        this.siteId = siteId;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Signature getSignature() {
        return signature;
    }

    public void setSignature(Signature signature) {
        this.signature = signature;
    }

}
