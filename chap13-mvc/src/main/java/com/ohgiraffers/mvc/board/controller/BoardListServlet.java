package com.ohgiraffers.mvc.board.controller;

import com.ohgiraffers.mvc.board.model.dto.BoardDTO;
import com.ohgiraffers.mvc.board.model.service.BoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {

    private final BoardService boardService = new BoardService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;
        int pageSize = 5;

        List<BoardDTO> boardList = boardService.getBoardsByPage(currentPage, pageSize);

        int totalBoards = boardService.getTotalBoardCount();
        int totalPages = (int) Math.ceil((double) totalBoards / pageSize);

        req.setAttribute("boardList", boardList);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("totalPages", totalPages);

        String path = "";
        if (boardList != null && !boardList.isEmpty()) {
            path = "/WEB-INF/views/board/boardList.jsp";
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "게시글 목록을 불러오는 데 실패했습니다.");
        }

        req.getRequestDispatcher(path).forward(req, resp);
    }
}
