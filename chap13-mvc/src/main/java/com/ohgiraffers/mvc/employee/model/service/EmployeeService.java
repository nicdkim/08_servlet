package com.ohgiraffers.mvc.employee.model.service;

import com.ohgiraffers.mvc.employee.model.dao.EmployeeDAO;
import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.*;


public class EmployeeService {

    private final EmployeeDAO empDAO;

    public EmployeeService() {
        empDAO = new EmployeeDAO();
    }

    public EmployeeDTO selectOneEmpById(String empId) {

        Connection con = getConnection();

        EmployeeDTO selectEmp = empDAO.selectEmpById(con, empId);

        close(con);

        return selectEmp;
    }

    public List<EmployeeDTO> selectAllNQEmployees() {

        Connection con = getConnection();
        List<EmployeeDTO> empList = empDAO.selectAllQNEmployees(con);
        close(con);
        return empList;

    }

    public int selectNewEmpId() {

        // AUTO_INCREMENT 가 걸려 있는 경우는 필요 없지만, 제일 끝 번호를 추적해 직접 값을 넣어주는 메소드
        Connection con = getConnection();

        int newEmpId = empDAO.selectNewEmpId(con);

        close(con);

        return newEmpId;

    }

    public int insertEmp(EmployeeDTO emp) {

        Connection con = getConnection();

        int result = empDAO.insertEmp(con, emp);

        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        return result;
    }

    public int updateEmployeeEntDate(int empId, Date entDate) {

        Connection con = getConnection();

        int result = empDAO.updateEmp(con, empId, entDate);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        return result;

    }

    public int deleteEmployee(int empId) {

        Connection con = getConnection();

        int result = empDAO.deleteEmployee(con, empId);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        return result;
    }

}
