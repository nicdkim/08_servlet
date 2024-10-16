package com.ohgiraffers.section02.uses;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;

@WebServlet("/member/regist")
public class RegistMemberServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String name = req.getParameter("name");

        System.out.println("userId : " + userId);
        System.out.println("password : " + password);
        System.out.println("name : " + name);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("비밀번호가 pass01인지 확인 : "
                            + encoder.matches("pass01", password));
    }
}
