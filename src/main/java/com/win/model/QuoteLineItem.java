package com.win.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class QuoteLineItem {

    @Id
    @GeneratedValue
    private Long quoteLineItemId;

    private String skuId;

    private Integer quantity;

    @ManyToOne
    private Quote parentQuote;

    public Long getQuoteLineItemId() {
        return quoteLineItemId;
    }

    public void setQuoteLineItemId(Long quoteLineItemId) {
        this.quoteLineItemId = quoteLineItemId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Quote getParentQuote() {
        return parentQuote;
    }

    public void setParentQuote(Quote parentQuote) {
        this.parentQuote = parentQuote;
    }

}