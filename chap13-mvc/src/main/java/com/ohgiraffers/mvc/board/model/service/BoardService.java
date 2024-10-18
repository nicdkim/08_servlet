package com.ohgiraffers.mvc.board.model.service;

import com.ohgiraffers.mvc.board.model.dao.BoardDAO;
import com.ohgiraffers.mvc.board.model.dto.BoardDTO;
import java.sql.Connection;
import java.util.List;
import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.*;

public class BoardService {

    private final BoardDAO boardDAO;

    public BoardService() {
        boardDAO = new BoardDAO();
    }

    public List<BoardDTO> selectAllBoards() {

        Connection con = getConnection();
        List<BoardDTO> boardList = boardDAO.selectAll(con);
        close(con);
        return boardList;
    }

    public BoardDTO selectBoardById(int boardId) {

        Connection con = getConnection();
        BoardDTO board = boardDAO.selectById(con, boardId);
        close(con);
        return board;
    }

    public int insertBoard(BoardDTO board) {

        Connection con = getConnection();

        int result = boardDAO.insert(con, board);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
        return result;
    }

    public int updateBoard(BoardDTO board) {

        Connection con = getConnection();

        int result = boardDAO.update(con, board);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
        return result;
    }

    public int deleteBoard(int boardId) {

        Connection con = getConnection();

        int result = boardDAO.delete(con, boardId);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
        return result;
    }

    public List<BoardDTO> getBoardsByPage(int currentPage, int pageSize) {
        Connection con = getConnection();
        List<BoardDTO> boardList = boardDAO.selectBoardsByPage(con, currentPage, pageSize);
        close(con);
        return boardList;
    }

    public int getTotalBoardCount() {
        Connection con = getConnection();
        int totalCount = boardDAO.selectTotalBoardCount(con);
        close(con);
        return totalCount;
    }
}
