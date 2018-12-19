package com.financialassets.controller;

import com.financialassets.apiclient.IEXChartClient;
import com.financialassets.apiclient.IEXChartResponse;
import com.financialassets.entity.User;
import com.financialassets.entity.UserAsset;
import com.financialassets.persistence.Common;
import com.financialassets.persistence.DaoFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(
        name="view-assets", urlPatterns = {"/ViewAssets"}
)


public class UserAssetSummary extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         IEXChartClient client = new IEXChartClient();
        List<IEXChartResponse> stockData = new ArrayList<>();



        try {
            stockData = client.getJSONResults("tsla", "5y");
        } catch (Exception e){

        }*/

        List<UserAsset> userAssets;
        String email = req.getRemoteUser();
        int userId = 0;
        //Get user's id
        DaoFactory userDao = new DaoFactory(User.class);
        List<User> users = userDao.getAll();

        for (User user : users) {
            if(user.getEmail().equals(email)) {
                userId = user.getUserId();
            }
        }




        if(req.isUserInRole("admin")) {
            userAssets = getAllUserAssets(userId);
            req.setAttribute("userAssets", userAssets);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view-assets.jsp");
            dispatcher.forward(req, resp);

        } else if(req.isUserInRole("registered-user")) {
            userAssets = getAllUserAssets(userId);
            req.setAttribute("userAssets", userAssets);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view-assets.jsp");
            dispatcher.forward(req, resp);

        } else {
        }




    }

    /**
     *
     * @param userId
     * @return List of all userassets in database
     */
    public List<UserAsset> getAllUserAssets(int userId) {

        List<UserAsset> userAssets = new Common().matchUserAssets(userId);

        return userAssets;
    }

}
