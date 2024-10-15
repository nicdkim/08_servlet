package com.ohgiraffers.question;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/postSuccess")
public class Post extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String title = (String) req.getAttribute("title");
        String content = (String) req.getAttribute("content");

        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().write("<h1>게시글이 작성되었습니다</h1>");
        resp.getWriter().write("<p>제목: " + title + "</p>");
        resp.getWriter().write("<p>내용: " + content + "</p>");
    }
}
