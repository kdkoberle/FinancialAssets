package com.financialassets.controller;

import com.financialassets.entity.UserAsset;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(
        name = "summary",
        urlPatterns = {"/summary"}
)


public class UserAssetSummary extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserAsset userAsset = new UserAsset();
        //req.setAttribute("users", userDa.getAUser(req.getParameter("last_name")));
        //RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        //dispatcher.forward(req, resp);
    }

}
