package com.win.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Quote {

    @Id
    @GeneratedValue
    private Long quoteId;

    private String name;

    private Double price;

    private Date createdOn;

    private Date updatedOn;

    @OneToMany(mappedBy = "parentQuote")
    private List<QuoteLineItem> quoteLineItems;

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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public List<QuoteLineItem> getQuoteLineItems() {
        return quoteLineItems;
    }

    public void setQuoteLineItems(List<QuoteLineItem> quoteLineItems) {
        this.quoteLineItems = quoteLineItems;
    }
    
}