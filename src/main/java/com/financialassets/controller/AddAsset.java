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
import java.util.List;

@WebServlet(
        name="AddAsset", urlPatterns = "/AddAsset"
)

//todo validation error handling
public class AddAsset extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getRemoteUser();
        User userMatch = new User();
        DaoFactory userDao;
        DaoFactory userAssetDao;
        UserAsset userAsset;

        userDao = new DaoFactory(User.class);
        List<User> userList = userDao.getAll();



        //Get correct user object
        for (User user : userList) {
            if(user.getEmail().equals(email)) {
                userMatch = user;
            }
        }

        userAssetDao = new DaoFactory(UserAsset.class);

        String name = request.getParameter("name").toUpperCase();
        LocalDate buyDate = LocalDate.parse(request.getParameter("dateBought"));
        Integer qty = Integer.parseInt(request.getParameter("qtyBought"));
        double price = Double.parseDouble(request.getParameter("price"));
        double fees = Double.parseDouble(request.getParameter("fees"));

        userAsset = new UserAsset(userMatch, price, buyDate, qty, name, fees);

        userAssetDao.insert(userAsset);

        request.setAttribute("price", price);
        request.setAttribute("dateBought", buyDate);
        request.setAttribute("name", name);
        request.setAttribute("qtyBought", qty);
        request.setAttribute("fees", fees);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/add-success.jsp");

        dispatcher.forward(request, response);


    }


}

