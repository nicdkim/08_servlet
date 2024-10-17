package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/employee/list")
public class EmployeeListServlet extends HttpServlet {

    private final EmployeeService employeeService = new EmployeeService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<EmployeeDTO> empList = employeeService.selectAllNQEmployees();

        req.setAttribute("empList", empList);

        String path = "";
        if(empList != null) {
            path = "/WEB-INF/views/employee/employeeList.jsp";
            req.setAttribute("empList", empList);
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "직원 목록 전체 조회 실패");
        }

        req.getRequestDispatcher(path).forward(req, resp);
    }
}
