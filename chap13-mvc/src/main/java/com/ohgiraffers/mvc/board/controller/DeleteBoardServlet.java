package com.ohgiraffers.mvc.board.controller;

import com.ohgiraffers.mvc.board.model.service.BoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/board/delete")
public class DeleteBoardServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int boardId = Integer.parseInt(req.getParameter("boardId"));

        BoardService boardService = new BoardService();
        int result = boardService.deleteBoard(boardId);

        String path = "";
        if (result > 0) {
            path = "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("successCode", "deleteBoard");
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "게시글 삭제에 실패했습니다.");
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
