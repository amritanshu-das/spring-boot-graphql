package com.win.graphql.query;

import java.util.Set;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.win.service.QuoteService;
import com.win.vo.response.QuoteBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuoteQuery implements GraphQLQueryResolver {

    private QuoteService quoteService;
    
    public Set<QuoteBody> quotes() {
        return getQuoteService().fetchAllQuotes();
    }

    public QuoteBody quote(Long pQuoteId) {
        return getQuoteService().fetchQuote(pQuoteId);
    }
    
    public QuoteService getQuoteService() {
        return quoteService;
    }
    
    @Autowired
    public void setQuoteService(final QuoteService quoteService) {
        this.quoteService = quoteService;
    }
}