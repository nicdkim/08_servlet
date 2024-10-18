package com.ohgiraffers.mvc.board.model.dto;

import java.sql.Timestamp;

public class BoardDTO {
    private int boardId;
    private String title;
    private String content;
    private String empId;
    private String empName;
    private java.sql.Timestamp createdAt;

    public BoardDTO() {

    }

    public BoardDTO(int boardId, String title, String content, String empId, String empName, Timestamp createdAt) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.empId = empId;
        this.empName = empName;
        this.createdAt = createdAt;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public java.sql.Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "boardId=" + boardId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

