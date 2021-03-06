package com.financialassets.apiclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class IEXQuoteClient {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private String baseUrl = "https://api.iextrading.com/1.0/stock/";


    /**
     * This method produces JSON results for stock quote.
     * @param symbol The stock symbol
     * @return results The list of the apartment search results.
     * @throws Exception The generic exception.
     */
    public IEXQuoteResponse getJSONResults(String symbol) throws Exception {

        IEXQuoteResponse result;

        String targetUrl = baseUrl + symbol + "/quote";


        String response = getResponse(MediaType.APPLICATION_JSON, targetUrl);

        ObjectMapper mapper = new ObjectMapper();
        result = mapper.readValue(response, IEXQuoteResponse.class);

        return result;
    }

    private String getResponse(String mediaType, String targetUrl) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(targetUrl);
        String response = "";

        try {
            response = target.request(mediaType).get(String.class);

        } catch (Exception exception) {
            logger.error(exception);
        } finally {
            client.close();
        }

        return response;
    }

}
