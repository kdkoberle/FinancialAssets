package com.financialassets.apiclient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class IEXChartClient {

    private String baseUrl = "https://api.iextrading.com/1.0/stock/";
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * This method produces JSON results for chart history.
     * @param symbol The stock symbol
     * @param range The range to get
     * @return results The list of the apartment search results.
     * @throws Exception The generic exception.
     */
    public List<IEXChartResponse> getJSONResults(String symbol, String range) throws Exception {

        List<IEXChartResponse> results = new ArrayList<>();

        String targetUrl = baseUrl + symbol + "/chart/" + range;


        String response = getResponse(MediaType.APPLICATION_JSON, targetUrl, results);


        ObjectMapper mapper = new ObjectMapper();
        results = mapper.readValue(response, new TypeReference<List<IEXChartResponse>>() {
        });

        return results;
    }

    /**
     *
     * @param mediaType
     * @param targetUrl
     * @param stockChart
     * @return
     */
    private String getResponse(String mediaType, String targetUrl, List<IEXChartResponse> stockChart) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(targetUrl);
        String response = "";

        try {
            response = target.request(mediaType).get(String.class);

        } catch (Exception exception) {
            logger.error(exception);

            IEXChartResponse stockHistory = new IEXChartResponse();
            stockChart.add(stockHistory);
        } finally {
            client.close();
        }

        return response;
    }





}

