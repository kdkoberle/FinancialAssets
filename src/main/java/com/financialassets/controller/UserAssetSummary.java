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
        //name="view-assets", urlPatterns = {"/view-assets.jsp"}
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




        //req.setAttribute("stockData", stockData);

        if(req.isUserInRole("admin")) {
            userAssets = getAllUserAssets();
            req.setAttribute("userAssets", userAssets);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view-assets.jsp");
            dispatcher.forward(req, resp);

        } else if(req.isUserInRole("registered-user")) {
            userAssets = getAllUserAssets();
            req.setAttribute("userAssets", userAssets);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view-assets.jsp");
            dispatcher.forward(req, resp);

        } else {
            userAssets = getAllUserAssets();
            req.setAttribute("userAssets", userAssets);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view-assets.jsp");
            dispatcher.forward(req, resp);
        }




    }

    public List<UserAsset> getAllUserAssets() {
        DaoFactory assetsDao = new DaoFactory(UserAsset.class);
        List<UserAsset> userAssets = assetsDao.getAll();

        //set gain or loss
        for (UserAsset asset : userAssets) {
            asset.setUnsoldGainOrLoss(asset.getAssetName());
        }

        return userAssets;
    }

}
