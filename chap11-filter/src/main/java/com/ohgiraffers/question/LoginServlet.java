package com.ohgiraffers.question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.io.IOException;
import java.util.Map;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();
        Map<String, String> users = (Map<String, String>) session.getAttribute("users");

        if (users != null && users.containsKey(userId)) {
            String hashedPWD = users.get(userId);

            if (passwordEncoder.matches(password, hashedPWD)) {
                session.setAttribute("userId", userId);
                resp.sendRedirect("main.jsp");
            } else {
                req.setAttribute("loginError", "id나 비밀번호가 다릅니다.");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("loginError", "id나 비밀번호가 다릅니다.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
