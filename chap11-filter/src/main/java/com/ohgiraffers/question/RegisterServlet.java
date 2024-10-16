package com.ohgiraffers.question;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private Map<String, String> users = new HashMap<>();
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        String hashedPWD = passwordEncoder.encode(password);

        users.put(userId, hashedPWD);
        req.getSession().setAttribute("users", users);

        resp.sendRedirect("login.jsp");
    }
}

