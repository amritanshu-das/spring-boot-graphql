package com.win.vo.input;

import java.util.Set;

public class QuoteInput {

    private String name;

    private Double price;

    private Set<QuoteLineItemInput> lineItems;

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

    public Set<QuoteLineItemInput> getLineItems() {
        return lineItems;
    }

    public void setLineItems(Set<QuoteLineItemInput> lineItems) {
        this.lineItems = lineItems;
    }
}