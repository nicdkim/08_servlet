package com.ohgiraffers.mvc.board.controller;

import com.ohgiraffers.mvc.board.model.dto.BoardDTO;
import com.ohgiraffers.mvc.board.model.service.BoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/edit")
public class EditBoardServlet extends HttpServlet {

    private final BoardService boardService = new BoardService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String boardIdParam = req.getParameter("boardId");

        if (boardIdParam != null && !boardIdParam.isEmpty()) {
            int boardId = Integer.parseInt(boardIdParam);

            BoardDTO board = boardService.selectBoardById(boardId);

            if (board != null) {
                req.setAttribute("board", board);
                req.getRequestDispatcher("/WEB-INF/views/board/editBoard.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "게시글을 불러오는 데 실패했습니다.");
                req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("message", "유효하지 않은 게시글 ID입니다.");
            req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int boardId = Integer.parseInt(req.getParameter("boardId"));
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        BoardDTO board = new BoardDTO();
        board.setBoardId(boardId);
        board.setTitle(title);
        board.setContent(content);

        BoardService boardService = new BoardService();
        int result = boardService.updateBoard(board);

        String path = "";
        if (result > 0) {
            path = "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("successCode", "updateBoard");
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "게시글 수정에 실패했습니다.");
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
