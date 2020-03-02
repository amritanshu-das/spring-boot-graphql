package com.win.vo.response;

import java.util.List;

public class QuoteBody {

    private Long quoteId;

    private String name;

    private Double price;
    
    private List<QuoteLineItemBody> lineItems;
    
    private String createdAt;

    private String updatedAt;

    public Long getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(Long quoteId) {
        this.quoteId = quoteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<QuoteLineItemBody> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<QuoteLineItemBody> lineItems) {
        this.lineItems = lineItems;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}