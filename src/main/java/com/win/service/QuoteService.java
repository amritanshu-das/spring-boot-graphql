package com.win.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.win.model.Quote;
import com.win.model.QuoteLineItem;
import com.win.repository.QuoteLineItemRepository;
import com.win.repository.QuoteRepository;
import com.win.vo.input.QuoteInput;
import com.win.vo.input.QuoteLineItemInput;
import com.win.vo.response.QuoteBody;
import com.win.vo.response.QuoteLineItemBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuoteService {

    private QuoteRepository quoteRepository;

    private QuoteLineItemRepository quoteLineItemRepository;

    @Transactional(readOnly = true)
    public Set<QuoteBody> fetchAllQuotes() {
        Set<QuoteBody> lResponseQuotes = new HashSet<QuoteBody>();
        
        final Iterable<Quote> lQuotes = getQuoteRepository().findAll();
        lQuotes.forEach(lQuote -> {
            QuoteBody lQuoteBody = new QuoteBody();
            lQuoteBody.setName(lQuote.getName());
            lQuoteBody.setPrice(lQuote.getPrice());
            lQuoteBody.setQuoteId(lQuote.getQuoteId());
            
            addQuoteLineItems(lQuote, lQuoteBody);
            lResponseQuotes.add(lQuoteBody);
        });
        return lResponseQuotes;
    }

    @Transactional(readOnly = true)
    public QuoteBody fetchQuote(Long pQuoteId) {
        final Quote lQuote = getQuoteRepository().findById(pQuoteId).get();
        QuoteBody lQuoteBody = buildQuoteBody(lQuote);
		return lQuoteBody;
    }

    @Transactional
    public QuoteBody createQuote(QuoteInput pQuoteInput) {
        Quote lQuote = new Quote();
        lQuote.setName(pQuoteInput.getName());
        lQuote.setPrice(pQuoteInput.getPrice());

        final Quote lSavedQuote = getQuoteRepository().save(lQuote);
        
        Set<QuoteLineItemInput> lQuoteInputLineItems = pQuoteInput.getLineItems();
        if (lQuoteInputLineItems != null && lQuoteInputLineItems.size() > 0) {
            lQuoteInputLineItems.forEach(lQuoteInputLineItem -> {
                QuoteLineItem lQuoteLineItem = new QuoteLineItem();
                lQuoteLineItem.setQuantity(lQuoteInputLineItem.getQuantity());
                lQuoteLineItem.setSkuId(lQuoteInputLineItem.getSku());
                lQuoteLineItem.setParentQuote(lSavedQuote);
                getQuoteLineItemRepository().save(lQuoteLineItem);
            });
        }

        return buildQuoteBody(lSavedQuote);
    }
    
    private QuoteBody buildQuoteBody(final Quote lQuote) {
        QuoteBody lQuoteBody = new QuoteBody();
        lQuoteBody.setName(lQuote.getName());
        lQuoteBody.setPrice(lQuote.getPrice());
        lQuoteBody.setQuoteId(lQuote.getQuoteId());
        addQuoteLineItems(lQuote, lQuoteBody);
        return lQuoteBody;
    }
    
    private void addQuoteLineItems(Quote lQuote, QuoteBody lQuoteBody) {
        final List<QuoteLineItem> lQuoteLineItems = lQuote.getQuoteLineItems();
        
        if (lQuoteLineItems != null) {
            List<QuoteLineItemBody> lLineItems = new ArrayList<QuoteLineItemBody>(lQuoteLineItems.size());
            lQuoteLineItems.forEach(lQuoteLineItem -> {
                QuoteLineItemBody lLineItemBody = new QuoteLineItemBody();
                lLineItemBody.setQuantity(lQuoteLineItem.getQuantity());
                lLineItemBody.setSku(lQuoteLineItem.getSkuId());

                lLineItems.add(lLineItemBody); 
            });
            
            lQuoteBody.setLineItems(lLineItems);
        }
    }

    public QuoteRepository getQuoteRepository() {
        return quoteRepository;
    }

    @Autowired
    public void setQuoteRepository(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public QuoteLineItemRepository getQuoteLineItemRepository() {
        return quoteLineItemRepository;
    }

    @Autowired
    public void setQuoteLineItemRepository(QuoteLineItemRepository quoteLineItemRepository) {
        this.quoteLineItemRepository = quoteLineItemRepository;
    }
}