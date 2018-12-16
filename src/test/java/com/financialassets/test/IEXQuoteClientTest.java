package com.financialassets.test;

import com.financialassets.apiclient.IEXQuoteClient;
import com.financialassets.apiclient.IEXQuoteResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IEXQuoteClientTest {

    IEXQuoteClient quoteClient = new IEXQuoteClient();
    IEXQuoteResponse quoteResponse = new IEXQuoteResponse();

    @Test
    void getJSONResults() {
        try {
            quoteResponse = quoteClient.getJSONResults("tsla");
        } catch (Exception e){

        }

        assertNotEquals(null, quoteResponse);
        assertEquals("Nasdaq Global Select", quoteResponse.getPrimaryExchange());
    }

}