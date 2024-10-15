package com.ohgiraffers.section01.forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/forward")
public class ReciveInformationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        System.out.println("userId = " + userId);
        System.out.println("password = " + password);

        // 다른 서블릿으로 데이터를 request setAttribute로 전달한다
        req.setAttribute("userId", userId);

        // print 라는 경로로 요청을 넘기기 위한 객체 생성
        // 이 경로는  서블릿이나 JSP 모두 가능
        RequestDispatcher rd = req.getRequestDispatcher("print");

        rd.forward(req,resp);


    }
}
