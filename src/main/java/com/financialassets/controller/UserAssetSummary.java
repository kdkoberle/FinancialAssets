package com.financialassets.controller;

import com.financialassets.entity.UserAsset;
import com.financialassets.persistence.DaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/testing.jsp"}
)


public class UserAssetSummary extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserAsset userAsset = new UserAsset();
        DaoFactory assetsDao = new DaoFactory(UserAsset.class);
        req.setAttribute("userAssets", assetsDao.getAll());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/view-assets.jsp");
        dispatcher.forward(req, resp);
    }

}
