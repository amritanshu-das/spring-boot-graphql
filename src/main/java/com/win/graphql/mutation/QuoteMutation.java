package com.win.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.win.service.QuoteService;
import com.win.vo.input.QuoteInput;
import com.win.vo.response.QuoteBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuoteMutation implements GraphQLMutationResolver {

    private QuoteService quoteService;

    public QuoteBody createQuote(QuoteInput pQuoteInput) {
        return getQuoteService().createQuote(pQuoteInput);
    }

    public QuoteService getQuoteService() {
        return quoteService;
    }

    @Autowired
    public void setQuoteService(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

}