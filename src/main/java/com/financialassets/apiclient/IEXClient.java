package com.financialassets.apiclient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class IEXClient {

    /**
     * This method produces JSON results.
     * @param symbol The stock symbol
     * @param range The range to get
     * @return results The list of the apartment search results.
     * @throws Exception The generic exception.
     */
    public List<IEXResponse> getJSONResults(String symbol, String range) throws Exception {
        List<IEXResponse> results = new ArrayList<>();

        String targetUrl = "https://api.iextrading.com/1.0/stock/" + symbol + "/chart/" + range;


        String response = getResponse(MediaType.APPLICATION_JSON, targetUrl, results);

        if (results.size() > 0)
            return results;

        ObjectMapper mapper = new ObjectMapper();
        results = mapper.readValue(response, new TypeReference<List<IEXResponse>>() {
        });

        return results;
    }

    private String getResponse(String mediaType, String targetUrl, List<IEXResponse> stockChart) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(targetUrl);
        String response = "";

        try {
            response = target.request(mediaType).get(String.class);

        } catch (Exception exception) {

            IEXResponse stockHistory = new IEXResponse();
            stockChart.add(stockHistory);
        }

        return response;
    }
}

