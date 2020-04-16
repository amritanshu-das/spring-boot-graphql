Sample Quote application using GraphQL

Mutation:

    mutation {
        createQuote(quoteInput: {name: "Test 3", price: 99, 
            lineItems: [
                {quantity: 1, sku: 87537339}, 
                {quantity: 2, sku: 56737432}]}) {
            quoteId
    }
}

Query:

    query {
        quotes {
            quoteId,
            name,
            lineItems {
                sku
            }
        }
    }