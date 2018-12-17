package com.financialassets.controller;

import com.financialassets.apiclient.IEXChartClient;
import com.financialassets.apiclient.IEXChartResponse;
import com.financialassets.entity.UserAsset;
import com.financialassets.persistence.DaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns = {"/testing.jsp"}
)


public class UserAssetSummary extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IEXChartClient client = new IEXChartClient();
        List<IEXChartResponse> stockData = new ArrayList<>();

        //TODO finish error handling

        try {
            stockData = client.getJSONResults("tsla", "5y");
        } catch (Exception e){

        }

        List<UserAsset> userAssets;
        DaoFactory assetsDao = new DaoFactory(UserAsset.class);
        userAssets = assetsDao.getAll();
        req.setAttribute("userAssets", userAssets);
        //req.setAttribute("stockData", stockData);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/view-assets.jsp");
        dispatcher.forward(req, resp);
        resp.sendRedirect("/view-assets.jsp");


    }

}
