package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("newuser"));

        // TODO: ensure the submitted information is valid

        // TODO: create a new user based off of the submitted information
        User userObj = new User(
                //1, // for now we'll hardcode the user id
                request.getParameter("newuser"),
                request.getParameter("newpass"),
                request.getParameter("email")
        );
        DaoFactory.getUserDao().insert(userObj);

        // NEED A SESSION TO ACCESS PROFILE PAGE
        request.getSession().setAttribute("user", userObj);
        response.sendRedirect("/profile");

        // TODO: if a user was successfully created, send them to their profile
    }
}
