package com.win.repository;

import com.win.model.QuoteLineItem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteLineItemRepository extends CrudRepository<QuoteLineItem, Long> {

}