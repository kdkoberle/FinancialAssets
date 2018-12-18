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
        name="SoldAsset", urlPatterns = "/SoldAsset"
)

public class SoldAsset extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        // Get userAsset id, and correct object
        int id = 0;
        id = Integer.parseInt(request.getParameter("id"));
        DaoFactory userAssetDao = new DaoFactory(UserAsset.class);
        List<UserAsset> allUserAssets = userAssetDao.getAll();
        UserAsset userAssetMatch = new UserAsset();

        for (UserAsset userAsset : allUserAssets) {
            if(userAsset.getUserAssetId() == id) {
                userAssetMatch = userAsset;
            }
        }


        double price = userAssetMatch.getBuyPrice();
        LocalDate buyDate = userAssetMatch.getBuyDate();
        String name = userAssetMatch.getAssetName();
        Integer qty = userAssetMatch.getQty();
        double fees = userAssetMatch.getFees();

        request.setAttribute("price", price);
        request.setAttribute("dateBought", buyDate);
        request.setAttribute("name", name);
        request.setAttribute("qtyBought", qty);
        request.setAttribute("fees", fees);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/sold-asset.jsp");

        dispatcher.forward(request, response);

    }


}
