package com.financialassets.controller;

import com.financialassets.entity.Role;
import com.financialassets.entity.User;
import com.financialassets.persistence.DaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name="Register", urlPatterns = "/Register"
)

//todo validation error handling

public class Register extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User newUser;
        List<User> allUsers;
        User userMatch = new User();
        Role newRole;
        DaoFactory userDao = new DaoFactory(User.class);
        DaoFactory roleDao = new DaoFactory(Role.class);



        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        /** make new user and insert */
        newUser = new User(email, password, firstName, lastName);
        userDao.insert(newUser);



        /** get user id of just inserted user */
        allUsers = userDao.getAll();
        for (User user: allUsers) {
            if(user.getEmail().equals(newUser.getEmail())) {
                userMatch = user;
            }
        }


        /** make instantiate role object, and insert */
        newRole = new Role(email, userMatch, "registered-user");
        roleDao.insert(newRole);


        request.setAttribute("firstName", firstName);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/register-success.jsp");

        dispatcher.forward(request, response);
    }

}