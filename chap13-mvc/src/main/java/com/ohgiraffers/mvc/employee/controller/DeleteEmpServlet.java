package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employee/delete")
public class DeleteEmpServlet extends HttpServlet {

    private final EmployeeService empService = new EmployeeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String empIdStr = req.getParameter("empId");

        int empId = Integer.parseInt(empIdStr);

        int result = empService.deleteEmployee(empId);

        String path = "";
        if(result > 0) {
            path = "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("successCode", "deleteEmp");
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "직원 삭제 처리 중 오류가 발생했습니다.");
        }
        req.getRequestDispatcher(path).forward(req, resp);

    }

}

