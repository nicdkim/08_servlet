package com.ohgiraffers.mvc.common.jdbc;

import com.ohgiraffers.mvc.common.config.ConfigLocation;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

// jdbc 연결을 관리하는 클래스
public class JDBCTemplate {

    // DB 연결을 생성하는 정적 메소드
    public static Connection getConnection() {

        Connection con = null;

        Properties prop = new Properties();

        try {
            prop.load(new FileReader(ConfigLocation.CONNECTION_CONFIG_LOCATION));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName(driver);

            con = DriverManager.getConnection(url,user,password);

            con.setAutoCommit(false);

        } catch (IOException e) {
            throw new RuntimeException("DB 설정 파일을 읽을 수 없음", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBC 드라이버를 로드할 수 없음", e);
        } catch (SQLException e) {
            throw new RuntimeException("DB 연결에 실패", e);
        }
        return con;
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException("Connection을 닫는 중 예외가 발생", e);
        }
    }

    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Statement를 닫는 중 예외가 발생", e);
        }
    }

    public static void close(ResultSet rset) {
        try {
            rset.close();
        } catch (SQLException e) {
            throw new RuntimeException("ResultSet을 닫는 중 예외가 발생", e);
        }
    }


    public static void commit(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException("커밋하는 중 예외가 발생", e);
        }
    }
    public static void rollback(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException("롤백하는 중 예외가 발생", e);
        }
    }
}

