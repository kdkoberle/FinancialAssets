package com.financialassets.apiclient;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IEXClientTest {
    IEXClient client = new IEXClient();
    List<IEXResponse> stockData = new ArrayList<>();

    @Test
    void getJSONResults() {
        try {
            stockData = client.getJSONResults("tsla", "5y");
        } catch (Exception e){

        }

        assertNotEquals(0, stockData.size());
        assertNotNull(stockData.get(100));
    }

}