package com.ohgiraffers.mvc.board.model.dao;

import com.ohgiraffers.mvc.board.model.dto.BoardDTO;
import com.ohgiraffers.mvc.common.config.ConfigLocation;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.close;

public class BoardDAO {

    private final Properties prop;

    public BoardDAO() {
        prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "board-mapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BoardDTO> selectAll(Connection con) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<BoardDTO> boardList = new ArrayList<>();

        String query = prop.getProperty("boardSelectAll");

        try {
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                BoardDTO board = new BoardDTO();
                board.setBoardId(rset.getInt("BOARD_ID"));
                board.setTitle(rset.getString("BOARD_TITLE"));
                board.setContent(rset.getString("BOARD_CONTENT"));
                board.setEmpId(rset.getString("EMP_ID"));
                board.setEmpName(rset.getString("EMP_NAME"));
                board.setCreatedAt(rset.getTimestamp("BOARD_CREATED_AT"));
                boardList.add(board);
            }

        } catch (SQLException e) {
            throw new RuntimeException("게시글 조회 중 오류 발생", e);
        } finally {
            close(rset);
            close(pstmt);
        }

        return boardList;
    }

    public int insert(Connection con, BoardDTO board) {
        String query = prop.getProperty("boardInsert");

        int result = 0;

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setString(3, board.getEmpId());
            pstmt.setString(4, board.getEmpName());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public BoardDTO selectById(Connection con, int boardId) {
        String query = prop.getProperty("boardSelectById");

        BoardDTO board = null;

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, boardId);

            try (ResultSet rset = pstmt.executeQuery()) {
                if (rset.next()) {
                    board = new BoardDTO();
                    board.setBoardId(rset.getInt("BOARD_ID"));
                    board.setTitle(rset.getString("BOARD_TITLE"));
                    board.setContent(rset.getString("BOARD_CONTENT"));
                    board.setEmpId(rset.getString("EMP_ID"));
                    board.setEmpName(rset.getString("EMP_NAME"));
                    board.setCreatedAt(rset.getTimestamp("BOARD_CREATED_AT"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return board;
    }

    public int update(Connection con, BoardDTO board) {
        String query = prop.getProperty("boardUpdate");

        int result = 0;

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setInt(3, board.getBoardId());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public int delete(Connection con, int boardId) {
        String query = prop.getProperty("boardDelete");

        int result = 0;

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, boardId);
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public List<BoardDTO> selectBoardsByPage(Connection con, int currentPage, int pageSize) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<BoardDTO> boardList = new ArrayList<>();

        String query = prop.getProperty("boardSelectByPage");

        try {
            pstmt = con.prepareStatement(query);
            int startRow = (currentPage - 1) * pageSize;
            pstmt.setInt(1, startRow);
            pstmt.setInt(2, pageSize);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                BoardDTO board = new BoardDTO();
                board.setBoardId(rset.getInt("BOARD_ID"));
                board.setTitle(rset.getString("BOARD_TITLE"));
                board.setContent(rset.getString("BOARD_CONTENT"));
                board.setEmpId(rset.getString("EMP_ID"));
                board.setEmpName(rset.getString("EMP_NAME"));
                board.setCreatedAt(rset.getTimestamp("BOARD_CREATED_AT"));
                boardList.add(board);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return boardList;
    }

    public int selectTotalBoardCount(Connection con) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        int totalCount = 0;

        String query = prop.getProperty("boardTotalCount");

        try {
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();
            if (rset.next()) {
                totalCount = rset.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return totalCount;
    }
}
