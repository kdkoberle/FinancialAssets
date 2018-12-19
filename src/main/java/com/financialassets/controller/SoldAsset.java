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

    //variables for get and post
    private int id = 0;
    private DaoFactory userAssetDao = new DaoFactory(UserAsset.class);
    private UserAsset userAssetMatch = new UserAsset();



    // handles post sent from view-assets.jsp
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        // Get userAsset id, and correct object

        id = Integer.parseInt(request.getParameter("id"));

        List<UserAsset> allUserAssets = userAssetDao.getAll();

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



    //handles get from sold-assets.jsp
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            double additionalFees = Double.parseDouble(request.getParameter("addtionalFees"));
            LocalDate soldDate = LocalDate.parse(request.getParameter("soldDate"));
            double sellPrice = Double.parseDouble(request.getParameter("sellPrice"));






    }

}
