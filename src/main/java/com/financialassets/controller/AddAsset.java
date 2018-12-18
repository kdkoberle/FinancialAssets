package com.financialassets.controller;

import com.financialassets.entity.User;
import com.financialassets.entity.UserAsset;
import com.financialassets.persistence.DaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(
        name="AddAsset", urlPatterns = "/AddAsset"
)
public class AddAsset extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DaoFactory userDao;
        DaoFactory userAssetDao;
        UserAsset userAsset;
        User user;

        userDao = new DaoFactory(User.class);
        user = (User)userDao.getById(3);

        userAssetDao = new DaoFactory(UserAsset.class);

        String name = request.getParameter("name").toUpperCase();
        LocalDate buyDate = LocalDate.parse(request.getParameter("dateBought"));
        Integer qty = Integer.parseInt(request.getParameter("qtyBought"));
        double buyPrice = Double.parseDouble(request.getParameter("price"));
        double fees = Double.parseDouble(request.getParameter("fees"));

        userAsset = new UserAsset(user, buyPrice, buyDate, qty, name, fees);

        userAssetDao.insert(userAsset);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/add-success.jsp");

        dispatcher.forward(request, response);


    }


}

