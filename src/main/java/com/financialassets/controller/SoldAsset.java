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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name="SoldAsset", urlPatterns = "/SoldAsset"
)


public class SoldAsset extends HttpServlet {

    //variables for get and post

    private int id = 0;
    private DaoFactory userAssetDao = new DaoFactory(UserAsset.class);
    private UserAsset userAssetMatch = new UserAsset();
    private List<UserAsset> allUserAssets = userAssetDao.getAll();
    private int userId = 0;


    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     *
     * this doPost gets information from the view-assets page and sends it to the sold-asset page
     * with the information to populate already known information
     */
    // handles post sent from view-assets.jsp
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        // Get userAsset id, and correct object

        id = Integer.parseInt(request.getParameter("id"));



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


    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     *  This doGet gets the user update information from sold-asset.jsp,
     *  updates the information, commits it, and then sends the userassets back
     *  to view-assets
     */
    //handles get from sold-assets.jsp
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            double additionalFees = Double.parseDouble(request.getParameter("additionalFees"));
            LocalDate soldDate = LocalDate.parse(request.getParameter("dateSold"));
            BigDecimal sellPrice = new BigDecimal(request.getParameter("sellPrice"));

            userAssetMatch.setSellDate(soldDate);
            userAssetMatch.setSellPrice(sellPrice);
            userAssetMatch.setFees(userAssetMatch.getFees() + additionalFees);

            userAssetDao.saveOrUpdate(userAssetMatch);

            List<UserAsset> matchUserAssets = new ArrayList<UserAsset>();

            userId = userAssetMatch.getUser().getUserId();

            //Set gain loss
            for (UserAsset userAsset : allUserAssets) {
                if(userAsset.getUser().getUserId() == userId) {
                    userAsset.setUnsoldGainOrLoss(userAsset.getAssetName());
                    matchUserAssets.add(userAsset);
                }
            }

            request.setAttribute("userAssets", matchUserAssets);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view-assets.jsp");

            dispatcher.forward(request, response);
    }

}
