package com.ohgiraffers.mvc.board.controller;

import com.ohgiraffers.mvc.board.model.dto.BoardDTO;
import com.ohgiraffers.mvc.board.model.service.BoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {

    private final BoardService boardService = new BoardService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String getBoardId = req.getParameter("boardId");

        System.out.println("boardDetail.getBoardId : " + getBoardId);

        String path = "";
        if (getBoardId != null && !getBoardId.isEmpty()) {
            try {
                int boardId = Integer.parseInt(getBoardId);

                BoardDTO board = boardService.selectBoardById(boardId);

                if (board != null) {
                    req.setAttribute("board", board);
                    path = "/WEB-INF/views/board/boardDetail.jsp";
                } else {
                    path = "/WEB-INF/views/common/errorPage.jsp";
                    req.setAttribute("message", "게시글을 불러오는 데 실패했습니다.");
                }

            } catch (NumberFormatException e) {
                path = "/WEB-INF/views/common/errorPage.jsp";
                req.setAttribute("message", "유효하지 않은 게시글 ID입니다.");
            }
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "게시글 ID가 제공되지 않았습니다.");
        }

        req.getRequestDispatcher(path).forward(req, resp);
    }
}
