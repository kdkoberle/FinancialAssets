package com.financialassets.controller;

import com.financialassets.entity.User;
import com.financialassets.entity.UserAsset;
import com.financialassets.persistence.Common;
import com.financialassets.persistence.DaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name="DeleteAsset", urlPatterns = "/DeleteAsset"
)
public class DeleteAsset extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * This servlet gets the asset_id from view-assets and deletes that asset from the database
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get userAsset id, and correct object
        int id = 0;
        id = Integer.parseInt(request.getParameter("id"));

        DaoFactory userAssetDao = new DaoFactory(UserAsset.class);

        List<UserAsset> allUserAssets = userAssetDao.getAll();

        //delete correct entry

        for (UserAsset userAsset : allUserAssets) {
            if(userAsset.getUserAssetId() == id) {
                userAssetDao.delete(userAsset);
            }
        }

        DaoFactory userDao = new DaoFactory(User.class);
        List<User> users = userDao.getAll();
        String email = request.getRemoteUser();
        int userId = 0;

        for (User user : users) {
            if(user.getEmail().equals(email)) {
                userId = user.getUserId();
            }
        }


        //Set gain loss
        List<UserAsset> matchOfUserAssets = new Common().matchUserAssets(userId);

        request.setAttribute("userAssets", matchOfUserAssets);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view-assets.jsp");
        dispatcher.forward(request, response);

    }
}
