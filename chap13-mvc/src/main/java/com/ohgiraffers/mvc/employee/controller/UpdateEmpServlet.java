package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/employee/update")
public class UpdateEmpServlet extends HttpServlet {

    private final EmployeeService empService = new EmployeeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int empId = Integer.parseInt(req. getParameter("empId"));
        Date entDate = Date.valueOf(req.getParameter("entDate"));

        System.out.println("empId : " + empId);
        System.out.println("entDate : " + entDate);

        int result = empService.updateEmployeeEntDate(empId, entDate);

        System.out.println("result : " + result);

        String path = "";
        if(result > 0) {
            path = "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("successCode", "updateEmp");
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "직원 퇴사 처리 중 오류가 발생했습니다.");
        }
        req.getRequestDispatcher(path).forward(req, resp);

    }
}
