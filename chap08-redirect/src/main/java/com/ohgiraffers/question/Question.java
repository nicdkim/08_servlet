package com.ohgiraffers.question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/submitPost")
public class Question extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        if (title != null && title.length() >= 5 && content != null && content.length() >= 10) {
            req.setAttribute("title", title);
            req.setAttribute("content", content);
            req.getRequestDispatcher("/postSuccess").forward(req, resp); // 성공 시 새 페이지로 포워딩
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}
