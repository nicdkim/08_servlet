package com.ohgiraffers.mvc.board.controller;

import com.ohgiraffers.mvc.board.model.dto.BoardDTO;
import com.ohgiraffers.mvc.board.model.service.BoardService;
import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/create")
public class CreateBoardServlet extends HttpServlet {

    private final EmployeeService empService = new EmployeeService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/views/board/newBoard.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String empId = req.getParameter("empId");
        String empName = req.getParameter("empName");
        String path = "";

        EmployeeDTO employee = empService.selectOneEmpById(empId);

        if (employee == null || !employee.getEmpName().equals(empName)) {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "사원 ID와 이름이 일치하지 않습니다.");
            req.getRequestDispatcher(path).forward(req, resp);
            return;
        }

        BoardDTO board = new BoardDTO();
        board.setTitle(title);
        board.setContent(content);
        board.setEmpId(empId);
        board.setEmpName(empName);

        BoardService boardService = new BoardService();
        int result = boardService.insertBoard(board);

        if (result > 0) {
            path = "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("successCode", "insertBoard");
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "게시글 작성에 실패했습니다.");
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
